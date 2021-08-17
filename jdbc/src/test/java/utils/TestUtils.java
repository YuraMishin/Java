package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * Class utils.TestUtils.
 * Implements resource utils.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.08.2021
 */
public final class TestUtils {
    /**
     * LOGGER.
     */
    private static final Logger LOGGER
        = LogManager.getLogger(TestUtils.class);

    /**
     * Constructor.
     */
    protected TestUtils() {
    }

    /**
     * Method loads text file from resources.
     *
     * @param file File
     * @return String
     */
    public static String loadText(final String file) {
        var path = Paths.get("src", "test", "resources", file);
        try {
            return Files.readString(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            LOGGER.error("Exception caught while reading file: {}",
                e.getMessage());
            throw new RuntimeException("Exception caught while reading file: "
                + e.getMessage(),
                e);
        }
    }

    /**
     * Method loads properties from resources.
     *
     * @param file File
     * @return Properties
     */
    public static Properties loadPropsFromResources(final String file) {
        var properties = new Properties();
        var path = Paths.get("src", "test", "resources", file);
        try (var is = new FileInputStream(path.toFile())) {
            properties.load(is);
            LOGGER.debug("DB Properties is successfully loaded");
            return properties;
        } catch (IOException e) {
            LOGGER.error("DB Properties loading is failed");
            LOGGER.error(String
                .format("%s %s",
                    ResourceUtils.loadText("msgs/PropsEx.txt"),
                    " {}"), e.getMessage());
            throw new RuntimeException(
                String
                    .format("%s %s",
                        ResourceUtils
                            .loadText("msgs/PropsEx.txt"),
                        e.getMessage()), e);
        }
    }
}
