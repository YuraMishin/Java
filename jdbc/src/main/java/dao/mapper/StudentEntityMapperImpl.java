package dao.mapper;

import dao.EntityMapper;
import model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class StudentEntityMapperImpl.
 * Implements StudentEntityMapper.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 11.08.2021
 */
public class StudentEntityMapperImpl implements EntityMapper<Student> {
    /**
     * Method maps ResultSet into Student.
     *
     * @param rs ResultSet
     * @return Student
     * @throws SQLException SQLException
     */
    @Override
    public Student map(final ResultSet rs) throws SQLException {
        return new Student(
            rs.getLong("id"),
            rs.getString("first_name"),
            rs.getString("last_name")
        );
    }
}
