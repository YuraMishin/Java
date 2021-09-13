package com.mishinyura.university.dao.mappers;

import com.mishinyura.university.domain.Time;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

/**
 * Class TimeRowMapper.
 * Implements Time row mapper.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 30.08.2021
 */
@Component("TimeRowMapper")
public class TimeRowMapper implements RowMapper<Time> {
    /**
     * @param rs ResultSet
     * @param i  I
     * @return Time
     * @throws SQLException SQLException
     */
    @Override
    public Time mapRow(final ResultSet rs, final int i) throws SQLException {
        return new Time(
            rs.getLong("id"),
            LocalTime.parse(rs.getString("startTime")),
            LocalTime.parse(rs.getString("endTime"))
        );
    }
}
