package com.cognizant.ormlearn;
import com.cognizant.ormlearn.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrmLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    public static void main(String[] args) { SpringApplication.run(OrmLearnApplication.class, args); LOGGER.info("Inside main"); }
    @Bean CommandLineRunner demo(CountryService service) {
        return args -> {
            LOGGER.info("Start");
            LOGGER.debug("countries={}", service.getAllCountries());
            LOGGER.debug("search ou={}", service.search("ou"));
            LOGGER.info("End");
        };
    }
}
