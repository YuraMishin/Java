package data;

import java.io.Closeable;
import java.sql.Connection;

/**
 * Interface DataSource.
 * Declares DataSource.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.08.2021
 */
public interface DataSource extends Closeable {
    /**
     * Method gets connection.
     *
     * @return Connection
     */
    Connection getConnection();
}
