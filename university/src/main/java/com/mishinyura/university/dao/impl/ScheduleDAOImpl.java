package com.mishinyura.university.dao.impl;

import com.mishinyura.university.dao.ScheduleDAO;
import com.mishinyura.university.dao.mappers.ScheduleRowMapper;
import com.mishinyura.university.domain.Schedule;
import com.mishinyura.university.utils.DBQueries;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Class ScheduleDAOImpl.
 * Implements ScheduleDAO.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 31.08.2021
 */
@Repository
public class ScheduleDAOImpl extends AbstractCrudDAO<Schedule, Long>
    implements ScheduleDAO {
    /**
     * JdbcTemplate.
     */
    private final JdbcTemplate jdbcTemplate;

    /**
     * UserRowMapper.
     */
    private final ScheduleRowMapper mapper;

    /**
     * Constructor.
     *
     * @param jdbcTemplate JdbcTemplate
     * @param mapper       Mapper
     */
    public ScheduleDAOImpl(
        final JdbcTemplate jdbcTemplate,
        final ScheduleRowMapper mapper) {

        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    /**
     * Method finds all schedule records.
     *
     * @return List<Schedule>
     */
    public List<Schedule> findAll() {
        return this.jdbcTemplate.query(
            DBQueries.ALL_SCHEDULES, mapper
        );
    }

    /**
     * Method finds schedule by id.
     *
     * @param id Id
     * @return Optional<Schedule>
     */
    @Override
    public Optional<Schedule> findById(final Long id) {
        return this.jdbcTemplate.query(
            DBQueries.SCHEDULE_BY_ID,
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
     * Method deletes schedule by id.
     *
     * @param id Id
     * @return boolean
     */
    @Override
    public boolean deleteById(final Long id) {
        var params = new Object[]{id};
        return this.
            jdbcTemplate.update(DBQueries.DELETE_SCHEDULE, params) == 1;
    }

    /**
     * Method creates schedule.
     *
     * @param schedule Schedule
     * @return Schedule
     */
    @Override
    protected Schedule create(final Schedule schedule) {
        var keyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(conn -> {
            var ps = conn.prepareStatement(
                DBQueries.CREATE_SCHEDULE,
                Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, schedule.getGroup().getId());
            return ps;
        }, keyHolder);
        schedule.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return schedule;
    }

    /**
     * Method updates schedule.
     *
     * @param schedule Schedule
     * @return Schedule
     */
    @Override
    protected Schedule update(final Schedule schedule) {
        var params = new Object[]{
            schedule.getGroup().getId(), schedule.getId()
        };
        var result = this
            .jdbcTemplate.update(DBQueries.UPDATE_SCHEDULE, params);
        if (result == 1) {
            return schedule;
        } else {
            throw new RuntimeException("Exception caught while updating");
        }
    }
}
