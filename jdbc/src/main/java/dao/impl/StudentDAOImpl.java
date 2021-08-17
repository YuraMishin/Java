package dao.impl;

import dao.CrudDAO;
import dao.mapper.StudentEntityMapperImpl;
import model.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ResourceUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class StudentDAOImpl.
 * Implements Student DAO.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.08.2021
 */
public class StudentDAOImpl extends AbstractCrudDAO implements CrudDAO {
    /**
     * Logger.
     */
    private static final Logger LOGGER
        = LogManager.getLogger(StudentDAOImpl.class);

    /**
     * SQL Exception message.
     */
    private static final String SQL_EX
        = ResourceUtils.loadText("msgs/SQLException.txt");

    /**
     * SQL Query.
     */
    private static final String INSERT
        = ResourceUtils.loadText("sql/insert.sql");

    /**
     * SQL Query.
     */
    private static final String UPDATE
        = ResourceUtils.loadText("sql/update.sql");

    /**
     * SQL Query.
     */
    private static final String FIND_BY_ID
        = ResourceUtils.loadText("sql/findById.sql");

    /**
     * SQL Query.
     */
    private static final String FIND_ALL
        = ResourceUtils.loadText("sql/findAll.sql");

    /**
     * SQL Query.
     */
    private static final String DELETE_BY_ID
        = ResourceUtils.loadText("sql/deleteById.sql");

    /**
     * StudentEntityMapper.
     */
    private final StudentEntityMapperImpl studentEntityMapper;

    /**
     * Student Entity Mapper.
     */
    public StudentDAOImpl() {
        this.studentEntityMapper = new StudentEntityMapperImpl();
    }

    /**
     * Method creates student.
     *
     * @param conn    Connection
     * @param student Student
     * @return Student
     */
    @Override
    protected Student create(final Connection conn, final Student student) {
        try (var ps = conn.prepareStatement(
            INSERT, Statement.RETURN_GENERATED_KEYS);
        ) {
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.executeUpdate();
            try (var rs = ps.getGeneratedKeys()) {
                rs.next();
                var newId = rs.getLong(1);
                return new Student(
                    newId,
                    student.getFirstName(),
                    student.getLastName());
            }
        } catch (SQLException e) {
            LOGGER.error(String
                .format("%s %s",
                    SQL_EX,
                    "{}"), e.getMessage());
            throw new RuntimeException(
                String.format("%s %s",
                    SQL_EX,
                    e.getMessage()),
                e);
        }
    }

    /**
     * Method updates student.
     *
     * @param conn    Connection
     * @param student Student
     * @return Student
     */
    @Override
    protected Student update(final Connection conn, final Student student) {
        try (var ps = conn.prepareStatement(UPDATE);
        ) {
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setLong(3, student.getId());
            var rowsUpdated = ps.executeUpdate();
            if (rowsUpdated != 0) {
                return student;
            } else {
                throw new SQLException(String
                    .format("%s - %s - %s",
                        getClass().getName(),
                        "update",
                        "wrong id"));
            }
        } catch (SQLException e) {
            LOGGER.error(String
                .format("%s %s",
                    SQL_EX,
                    "{}"), e.getMessage());
            throw new RuntimeException(
                String.format("%s %s",
                    SQL_EX,
                    e.getMessage()),
                e);
        }
    }

    /**
     * Method finds student by id.
     *
     * @param conn Connection
     * @param id   Id
     * @return Optional<Student>
     */
    @Override
    public Optional<Student> findById(final Connection conn, final Long id) {
        try (var ps = conn.prepareStatement(FIND_BY_ID);
        ) {
            ps.setLong(1, id);
            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(studentEntityMapper.map(rs));
                } else {
                    return Optional.empty();
                }
            }
        } catch (SQLException e) {
            LOGGER.error(String
                .format("%s %s",
                    SQL_EX,
                    "{}"), e.getMessage());
            throw new RuntimeException(
                String.format("%s %s",
                    SQL_EX,
                    e.getMessage()),
                e);
        }
    }

    /**
     * Method finds all students.
     *
     * @param conn Connection
     * @return List<Student>
     */
    @Override
    public List<Student> findAll(final Connection conn) {
        try (var ps = conn.prepareStatement(FIND_ALL);
        ) {
            try (var rs = ps.executeQuery()) {
                var students = new ArrayList<Student>();
                while (rs.next()) {
                    students.add(studentEntityMapper.map(rs));
                }
                return students;
            }
        } catch (SQLException e) {
            LOGGER.error(String
                .format("%s %s",
                    SQL_EX,
                    "{}"), e.getMessage());
            throw new RuntimeException(
                String.format("%s %s",
                    SQL_EX,
                    e.getMessage()),
                e);
        }
    }

    /**
     * Method deletes student by id.
     *
     * @param conn Connection
     * @param id   Id
     */
    @Override
    public void deleteById(final Connection conn, final Long id) {
        try (var ps = conn.prepareStatement(DELETE_BY_ID);
        ) {
            ps.setLong(1, id);
            var rowsUpdated = ps.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException(String
                    .format("%s - %s - %s",
                        getClass().getName(),
                        "deleteById",
                        "wrong id"));
            }
        } catch (SQLException e) {
            LOGGER.error(String
                .format("%s %s",
                    SQL_EX,
                    "{}"), e.getMessage());
            throw new RuntimeException(
                String.format("%s %s",
                    SQL_EX,
                    e.getMessage()),
                e);
        }
    }


}
