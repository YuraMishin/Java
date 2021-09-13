package com.mishinyura.university.dao.mappers;

import com.mishinyura.university.domain.Group;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class GroupRowMapper.
 * Implements group row mapper.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 30.08.2021
 */
@Component("groupRowMapper")
public class GroupRowMapper implements RowMapper<Group> {
    /**
     * @param rs ResultSet
     * @param i  I
     * @return Group
     * @throws SQLException SQLException
     */
    @Override
    public Group mapRow(final ResultSet rs, final int i) throws SQLException {
        return new Group(
            rs.getLong("id"),
            rs.getString("name")
        );
    }
}
