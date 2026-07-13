package com.cognizant.springlearn.controller;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.*;

@RestController
public class AuthenticationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
    private static final byte[] SECRET = "digital-nurture-jwt-secret-key-minimum-32".getBytes(StandardCharsets.UTF_8);
    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start");
        LOGGER.debug("authHeader={}", authHeader);
        String base64 = authHeader.replace("Basic ", "");
        String username = new String(Base64.getDecoder().decode(base64), StandardCharsets.UTF_8).split(":", 2)[0];
        String token = Jwts.builder().subject(username).issuedAt(Date.from(Instant.now())).expiration(Date.from(Instant.now().plusSeconds(20 * 60))).signWith(Keys.hmacShaKeyFor(SECRET)).compact();
        LOGGER.info("End");
        return Map.of("token", token);
    }
}
