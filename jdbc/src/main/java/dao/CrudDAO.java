package dao;

import model.Student;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

/**
 * Interface CrudDAO.
 * Declares DAO methods.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.08.2021
 */
public interface CrudDAO {
    /**
     * Method saves student.
     *
     * @param conn    Connection
     * @param student Student
     * @return Student
     */
    Student save(Connection conn, Student student);

    /**
     * Method finds student by id.
     *
     * @param conn Connection
     * @param id   Id
     * @return Optional<Student>
     */
    Optional<Student> findById(Connection conn, Long id);

    /**
     * Method finds all students.
     *
     * @param conn Connection
     * @return List<Student>
     */
    List<Student> findAll(Connection conn);

    /**
     * Method deletes student by id.
     *
     * @param conn Connection
     * @param id   Id
     */
    void deleteById(Connection conn, Long id);
}
