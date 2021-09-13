package com.mishinyura.university.dao.impl;

import com.mishinyura.university.dao.TimeDAO;
import com.mishinyura.university.dao.mappers.TimeRowMapper;
import com.mishinyura.university.domain.Time;
import com.mishinyura.university.utils.DBQueries;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Class TimeDAOImpl.
 * Implements TimeDAO.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 30.08.2021
 */
@Repository
public class TimeDAOImpl extends AbstractCrudDAO<Time, Long>
    implements TimeDAO {
    /**
     * JdbcTemplate.
     */
    private final JdbcTemplate jdbcTemplate;

    /**
     * TimeRowMapper.
     */
    private final TimeRowMapper mapper;

    /**
     * Constructor.
     *
     * @param jdbcTemplate JdbcTemplate
     * @param mapper       Mapper
     */
    public TimeDAOImpl(
        final JdbcTemplate jdbcTemplate,
        final TimeRowMapper mapper) {

        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    /**
     * Method finds all times.
     *
     * @return List<Time>
     */
    public List<Time> findAll() {
        return this.jdbcTemplate.query(
            DBQueries.ALL_TIMES, mapper
        );
    }

    /**
     * Method finds time by id.
     *
     * @param id Id
     * @return Optional<Time>
     */
    @Override
    public Optional<Time> findById(final Long id) {
        return this.jdbcTemplate.query(
            DBQueries.TIME_BY_ID,
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
     * Method deletes time by id.
     *
     * @param id Id
     * @return boolean
     */
    @Override
    public boolean deleteById(final Long id) {
        var params = new Object[]{id};
        return this.jdbcTemplate.update(DBQueries.DELETE_TIME, params) == 1;
    }

    /**
     * Method creates time.
     *
     * @param time time
     * @return time
     */
    @Override
    protected Time create(final Time time) {
        var keyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(conn -> {
            var ps = conn.prepareStatement(
                DBQueries.CREATE_TIME,
                Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, time.getStart().toString());
            ps.setString(2, time.getEnd().toString());
            return ps;
        }, keyHolder);
        time.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return time;
    }

    /**
     * Method updates time.
     *
     * @param time time
     * @return time
     */
    @Override
    protected Time update(final Time time) {
        var params = new Object[]{time.getStart(), time.getEnd(), time.getId()};
        var result = this.jdbcTemplate.update(DBQueries.UPDATE_TIME, params);
        if (result == 1) {
            return time;
        } else {
            throw new RuntimeException("Exception caught while updating");
        }
    }
}
