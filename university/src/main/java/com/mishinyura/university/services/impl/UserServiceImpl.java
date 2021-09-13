package com.mishinyura.university.services.impl;

import com.mishinyura.university.dao.UserDAO;
import com.mishinyura.university.domain.User;
import com.mishinyura.university.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Class UserServiceImpl.
 * Implements User service.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 07.09.2021
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * UserDAO.
     */
    private final UserDAO userDAO;

    /**
     * Constructor.
     *
     * @param userDAO UserDAO
     */
    public UserServiceImpl(final UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * Method finds all users.
     *
     * @return List<User>
     */
    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return this.userDAO.findAll();
    }

    /**
     * Method finds user by id.
     *
     * @param id Id
     * @return Optional<User>
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(final Long id) {
        return this.userDAO.findById(id);
    }

    /**
     * Method saves user.
     *
     * @param user User
     * @return User
     */
    @Override
    @Transactional
    public User save(final User user) {
        return this.userDAO.save(user);
    }

    /**
     * Method deletes user by id.
     *
     * @param id Id
     * @return boolean
     */
    @Override
    @Transactional
    public boolean deleteById(final Long id) {
        return this.userDAO.deleteById(id);
    }
}
