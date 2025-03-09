package com.griddynamics.rwhite_rabbitmq_capstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Main entry point for the Spring Boot application.
 * This class is responsible for bootstrapping the application.
 */
@SpringBootApplication
@EnableScheduling
@ConfigurationPropertiesScan
public class Application {

    /**
     * Main method which serves as the entry point for the Java application.
     * It delegates to Spring Boot's SpringApplication class to bootstrap the application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}