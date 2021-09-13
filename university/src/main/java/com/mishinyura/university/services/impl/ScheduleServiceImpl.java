package com.mishinyura.university.services.impl;

import com.mishinyura.university.dao.ScheduleDAO;
import com.mishinyura.university.domain.Schedule;
import com.mishinyura.university.services.ScheduleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Class ScheduleServiceImpl.
 * Implements Schedule service.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 07.09.2021
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {
    /**
     * ScheduleDAO.
     */
    private final ScheduleDAO scheduleDAO;

    /**
     * Constructor.
     *
     * @param scheduleDAO ScheduleDAO
     */
    public ScheduleServiceImpl(final ScheduleDAO scheduleDAO) {
        this.scheduleDAO = scheduleDAO;
    }

    /**
     * Method finds all schedules.
     *
     * @return List<Schedule>
     */
    @Override
    @Transactional(readOnly = true)
    public List<Schedule> findAll() {
        return this.scheduleDAO.findAll();
    }

    /**
     * Method finds schedule by id.
     *
     * @param id Id
     * @return Optional<Schedule>
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Schedule> findById(final Long id) {
        return this.scheduleDAO.findById(id);
    }

    /**
     * Method saves schedule.
     *
     * @param schedule Schedule
     * @return Schedule
     */
    @Override
    @Transactional
    public Schedule save(final Schedule schedule) {
        return this.scheduleDAO.save(schedule);
    }

    /**
     * Method deletes schedule by id.
     *
     * @param id Id
     * @return boolean
     */
    @Override
    @Transactional
    public boolean deleteById(final Long id) {
        return this.scheduleDAO.deleteById(id);
    }
}
