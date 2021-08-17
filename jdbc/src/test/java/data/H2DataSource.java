package data;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.TestUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class data.H2DataSource.
 * Implements Data Source.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.08.2021
 */
public final class H2DataSource implements DataSource {
    /**
     * LOGGER.
     */
    private static final Logger LOGGER
        = LogManager.getLogger(H2DataSource.class);

    /**
     * HIKARI DATASOURCE.
     */
    private static HikariDataSource dataSource;

    /**
     * JDBC_URL.
     */
    public static final String JDBC_URL = "JDBC_URL";

    /**
     * Constructor.
     *
     * @param properties Properties
     */
    public H2DataSource(final Properties properties) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(properties.getProperty(JDBC_URL));
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        dataSource = new HikariDataSource(config);
    }

    /**
     * Method gets connection.
     *
     * @return Connection
     */
    @Override
    public Connection getConnection() {
        try {
            var connection = dataSource.getConnection();
            LOGGER.debug("JDBC Driver is successfully connected");
            return connection;
        } catch (SQLException e) {
            LOGGER.error(String.format("%s %s",
                TestUtils
                    .loadText("msgs/ConnectionEx.txt"),
                "{}"),
                e.getMessage());
            throw new RuntimeException(
                String.format("%s %s",
                    TestUtils
                        .loadText("msgs/ConnectionEx.txt"),
                    e.getMessage()),
                e);
        }
    }

    @Override
    public void close() {
        dataSource.close();
        LOGGER.debug("Connection is successfully closed");
    }
}
