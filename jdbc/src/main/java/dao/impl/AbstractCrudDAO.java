package dao.impl;

import dao.CrudDAO;
import model.Student;

import java.sql.Connection;

/**
 * Class AbstractCrudDAO.
 * Declares AbstractCrudDAO.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 17.08.2021
 */
public abstract class AbstractCrudDAO implements CrudDAO {
    /**
     * Method saves student.
     *
     * @param conn    Connection
     * @param student Student
     * @return Student
     */
    @Override
    public Student save(final Connection conn, final Student student) {
        return student.getId() == null
            ? create(conn, student) : update(conn, student);
    }

    /**
     * Method creates student.
     *
     * @param conn    Connection
     * @param student Student
     * @return Student
     */
    protected abstract Student create(Connection conn, Student student);

    /**
     * Method updates student.
     *
     * @param conn    Connection
     * @param student Student
     * @return Student
     */
    protected abstract Student update(Connection conn, Student student);
}
