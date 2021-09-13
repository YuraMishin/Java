package com.mishinyura.university.services.impl;

import com.mishinyura.university.dao.GroupDAO;
import com.mishinyura.university.domain.Group;
import com.mishinyura.university.services.GroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Class GroupServiceImpl.
 * Implements Group service.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 07.09.2021
 */
@Service
public class GroupServiceImpl implements GroupService {
    /**
     * GroupDAO.
     */
    private final GroupDAO groupDAO;

    /**
     * Constructor.
     *
     * @param groupDAO groupDAO
     */
    public GroupServiceImpl(final GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    /**
     * Method finds all groups.
     *
     * @return List<Group>
     */
    @Override
    @Transactional(readOnly = true)
    public List<Group> findAll() {
        return this.groupDAO.findAll();
    }

    /**
     * Method finds group by id.
     *
     * @param id Id
     * @return Optional<Group>
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Group> findById(final Long id) {
        return this.groupDAO.findById(id);
    }

    /**
     * Method saves group.
     *
     * @param group group
     * @return group
     */
    @Override
    @Transactional
    public Group save(final Group group) {
        return this.groupDAO.save(group);
    }

    /**
     * Method deletes group by id.
     *
     * @param id Id
     * @return boolean
     */
    @Override
    @Transactional
    public boolean deleteById(final Long id) {
        return this.groupDAO.deleteById(id);
    }
}
