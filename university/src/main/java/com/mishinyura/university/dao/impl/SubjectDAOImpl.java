package com.mishinyura.university.dao.impl;

import com.mishinyura.university.dao.SubjectDAO;
import com.mishinyura.university.dao.mappers.SubjectRowMapper;
import com.mishinyura.university.domain.Subject;
import com.mishinyura.university.utils.DBQueries;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Class SubjectDAOImpl.
 * Implements SubjectDAO.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 30.08.2021
 */
@Repository
public class SubjectDAOImpl extends AbstractCrudDAO<Subject, Long>
    implements SubjectDAO {
    /**
     * JdbcTemplate.
     */
    private final JdbcTemplate jdbcTemplate;

    /**
     * SubjectRowMapper.
     */
    private final SubjectRowMapper mapper;

    /**
     * Constructor.
     *
     * @param jdbcTemplate JdbcTemplate
     * @param mapper       Mapper
     */
    public SubjectDAOImpl(
        final JdbcTemplate jdbcTemplate,
        final SubjectRowMapper mapper) {

        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    /**
     * Method finds all subjects.
     *
     * @return List<Subject>
     */
    public List<Subject> findAll() {
        return this.jdbcTemplate.query(
            DBQueries.ALL_SUBJECTS, mapper
        );
    }

    /**
     * Method finds subject by id.
     *
     * @param id Id
     * @return Optional<Subject>
     */
    @Override
    public Optional<Subject> findById(final Long id) {
        return this.jdbcTemplate.query(
            DBQueries.SUBJECT_BY_ID,
            rs -> {
                if (rs.next()) {
                    return Optional.ofNullable(mapper.mapRow(rs, 1));
                } else {
                    return Optional.empty();
                }
            },
            id
        );
    }

    /**
     * Method deletes subject by id.
     *
     * @param id Id
     * @return boolean
     */
    @Override
    public boolean deleteById(final Long id) {
        var params = new Object[]{id};
        return this.jdbcTemplate.update(DBQueries.DELETE_SUBJECT, params) == 1;
    }

    /**
     * Method creates subject.
     *
     * @param subject Subject
     * @return Subject
     */
    @Override
    protected Subject create(final Subject subject) {
        var keyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(conn -> {
            var ps = conn.prepareStatement(
                DBQueries.CREATE_SUBJECT,
                Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, subject.getName());
            return ps;
        }, keyHolder);
        subject.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return subject;
    }

    /**
     * Method updates subject.
     *
     * @param subject Subject
     * @return Subject
     */
    @Override
    protected Subject update(final Subject subject) {
        var params = new Object[]{subject.getName(), subject.getId()};
        var result = this.jdbcTemplate.update(DBQueries.UPDATE_SUBJECT, params);
        if (result == 1) {
            return subject;
        } else {
            throw new RuntimeException("Exception caught while updating");
        }
    }
}
