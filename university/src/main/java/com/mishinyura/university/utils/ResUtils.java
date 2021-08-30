package com.mishinyura.university.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Class ResUtils.
 * Implements Resources Utils.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 29.08.2021
 */
public final class ResUtils {
    /**
     * LOGGER.
     */
    private static final Logger LOGGER
        = LogManager.getLogger(ResUtils.class);

    /**
     * Constructor.
     */
    private ResUtils() {
    }

    /**
     * Method loads text file from resources.
     *
     * @param file File
     * @return String
     */
    public static String loadText(final String file) {
        try (var is = ResUtils.class.getClassLoader()
            .getResourceAsStream(file)) {
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.error(
                "Exception caught while reading text file: {}",
                e.getMessage());
            throw new RuntimeException(
                "Exception caught while reading text file: " + e.getMessage(),
                e);
        }
    }
}
