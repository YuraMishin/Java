package com.mishinyura.university.dao.mappers;

import com.mishinyura.university.domain.Subject;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class SubjectRM.
 * Implements subject row mapper.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 30.08.2021
 */
@Component("subjectRowMapper")
public class SubjectRM implements RowMapper<Subject> {
    /**
     * @param rs ResultSet
     * @param i  I
     * @return Subject
     * @throws SQLException SQLException
     */
    @Override
    public Subject mapRow(final ResultSet rs, final int i) throws SQLException {
        return new Subject(
            rs.getLong("id"),
            rs.getString("name")
        );
    }
}
