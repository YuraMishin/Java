package com.mishinyura.university.dao.mappers;

import com.mishinyura.university.domain.Classroom;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class ClassroomRM.
 * Implements Classroom row mapper.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 30.08.2021
 */
@Component("classroomRowMapper")
public class ClassroomRM implements RowMapper<Classroom> {
    /**
     * @param rs ResultSet
     * @param i  I
     * @return Classroom
     * @throws SQLException SQLException
     */
    @Override
    public Classroom mapRow(final ResultSet rs, final int i) throws SQLException {
        return new Classroom(
            rs.getLong("id"),
            rs.getString("name")
        );
    }
}
