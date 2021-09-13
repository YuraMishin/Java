package com.mishinyura.university.services.impl;

import com.mishinyura.university.dao.TimeDAO;
import com.mishinyura.university.domain.Time;
import com.mishinyura.university.services.TimeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Class TimeServiceImpl.
 * Implements Time service.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 07.09.2021
 */
@Service
public class TimeServiceImpl implements TimeService {
    /**
     * TimeDAO.
     */
    private final TimeDAO timeDAO;

    /**
     * Constructor.
     *
     * @param timeDAO TimeDAO
     */
    public TimeServiceImpl(final TimeDAO timeDAO) {
        this.timeDAO = timeDAO;
    }

    /**
     * Method finds all times.
     *
     * @return List<Time>
     */
    @Override
    @Transactional(readOnly = true)
    public List<Time> findAll() {
        return this.timeDAO.findAll();
    }

    /**
     * Method finds time by id.
     *
     * @param id Id
     * @return Optional<Time>
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Time> findById(final Long id) {
        return this.timeDAO.findById(id);
    }

    /**
     * Method saves time.
     *
     * @param time Time
     * @return Time
     */
    @Override
    @Transactional
    public Time save(final Time time) {
        return this.timeDAO.save(time);
    }

    /**
     * Method deletes time by id.
     *
     * @param id Id
     * @return boolean
     */
    @Override
    @Transactional
    public boolean deleteById(final Long id) {
        return this.timeDAO.deleteById(id);
    }
}
