package com.mishinyura.university.dao.mappers;

import com.mishinyura.university.domain.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class UserRM.
 * Implements user row mapper.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 28.08.2021
 */
@Component("userRowMapper")
public class UserRM implements RowMapper<User> {
    /**
     * @param rs ResultSet
     * @param i  I
     * @return User
     * @throws SQLException SQLException
     */
    @Override
    public User mapRow(final ResultSet rs, final int i) throws SQLException {
        return new User(
            rs.getLong("id"),
            rs.getString("name")
        );
    }
}
