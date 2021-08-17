package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Interface EntityMapper.
 * Declares EntityMapper.
 *
 * @param <T> Entity
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 18.08.2021
 */
public interface EntityMapper<T> {
    /**
     * Method maps ResultSet into Entity.
     *
     * @param rs ResultSet
     * @return Entity
     * @throws SQLException SQLException
     */
    T map(ResultSet rs) throws SQLException;
}
