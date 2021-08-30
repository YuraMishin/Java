package com.mishinyura.university;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Class StartApp.
 * Implements main app class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.08.2021
 */
@SpringBootApplication
@ComponentScan({"com.mishinyura.university"})
public class StartApp {
    /**
     * Constructor.
     */
    protected StartApp() {
    }

    /**
     * The app entry point.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        SpringApplication.run(StartApp.class, args);
    }
}
