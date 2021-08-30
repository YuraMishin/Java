package com.mishinyura.university.dao.impl;

import com.mishinyura.university.dao.ClassroomDAO;
import com.mishinyura.university.dao.mappers.ClassroomRM;
import com.mishinyura.university.domain.Classroom;
import com.mishinyura.university.utils.DBQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Class ClassroomDAOImpl.
 * Implements ClassroomDAO.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 30.08.2021
 */
@Repository
public class ClassroomDAOImpl extends AbstractCrudDAO<Classroom, Long>
    implements ClassroomDAO {
    /**
     * JdbcTemplate.
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * ClassroomRM.
     */
    @Autowired
    private ClassroomRM classroomRM;

    /**
     * Method finds all classrooms.
     *
     * @return List<Classroom>
     */
    public List<Classroom> findAll() {
        return this.jdbcTemplate.query(
            DBQueries.ALL_CLASSROOMS, classroomRM
        );
    }

    /**
     * Method finds Classroom by id.
     *
     * @param id Id
     * @return Optional<Classroom>
     */
    @Override
    public Optional<Classroom> findById(final Long id) {
        return this.jdbcTemplate.query(
            DBQueries.CLASSROOM_BY_ID,
            rs -> {
                if (rs.next()) {
                    return Optional.ofNullable(classroomRM.mapRow(rs, 1));
                } else {
                    return Optional.empty();
                }
            },
            id
        );
    }

    /**
     * Method deletes Classroom by id.
     *
     * @param id Id
     * @return boolean
     */
    @Override
    public boolean deleteById(final Long id) {
        var params = new Object[]{id};
        return this.jdbcTemplate
            .update(DBQueries.DELETE_CLASSROOM, params) == 1;
    }

    /**
     * Method creates classroom.
     *
     * @param classroom classroom
     * @return classroom
     */
    @Override
    protected Classroom create(final Classroom classroom) {
        var keyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(conn -> {
            var ps = conn.prepareStatement(
                DBQueries.CREATE_CLASSROOM,
                Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, classroom.getName());
            return ps;
        }, keyHolder);
        classroom.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return classroom;
    }

    /**
     * Method updates classroom.
     *
     * @param classroom classroom
     * @return classroom
     */
    @Override
    protected Classroom update(final Classroom classroom) {
        var params = new Object[]{classroom.getName(), classroom.getId()};
        var result = this.jdbcTemplate
            .update(DBQueries.UPDATE_CLASSROOM, params);
        if (result == 1) {
            return classroom;
        } else {
            throw new RuntimeException("Exception caught while updating");
        }
    }
}
