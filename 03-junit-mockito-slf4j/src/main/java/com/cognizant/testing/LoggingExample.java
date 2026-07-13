package com.cognizant.testing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingExample.class);
    public static void main(String[] args) {
        LOGGER.error("This is an error message");
        LOGGER.warn("This is a warning message");
        LOGGER.info("Parameterized log: user={} action={}", "student", "login");
    }
}
