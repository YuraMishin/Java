package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Class ResourceUtils.
 * Implements ResourceUtils.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 18.08.2021
 */
public final class ResourceUtils {
    /**
     * LOGGER.
     */
    private static final Logger LOGGER
        = LogManager.getLogger(ResourceUtils.class);

    /**
     * Constructor.
     */
    private ResourceUtils() {
    }

    /**
     * Method loads text file from resources.
     *
     * @param file File
     * @return String
     */
    public static String loadText(final String file) {
        try (var is = ResourceUtils.class.getClassLoader()
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
