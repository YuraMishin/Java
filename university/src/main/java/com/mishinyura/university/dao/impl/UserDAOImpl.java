package com.mishinyura.university.dao.impl;

import com.mishinyura.university.dao.UserDAO;
import com.mishinyura.university.dao.mappers.UserRowMapper;
import com.mishinyura.university.domain.User;
import com.mishinyura.university.utils.DBQueries;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Class UserDAOImpl.
 * Implements UserDAO.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.08.2021
 */
@Repository
public class UserDAOImpl extends AbstractCrudDAO<User, Long>
    implements UserDAO {
    /**
     * JdbcTemplate.
     */
    private final JdbcTemplate jdbcTemplate;

    /**
     * UserRowMapper.
     */
    private final UserRowMapper mapper;

    /**
     * Constructor.
     *
     * @param jdbcTemplate JdbcTemplate
     * @param mapper       Mapper
     */
    public UserDAOImpl(
        final JdbcTemplate jdbcTemplate,
        final UserRowMapper mapper) {

        this.jdbcTemplate = jdbcTemplate;
        this.mapper = mapper;
    }

    /**
     * Method finds all users.
     *
     * @return List<User>
     */
    public List<User> findAll() {
        return this.jdbcTemplate.query(
            DBQueries.ALL_USERS, mapper
        );
    }

    /**
     * Method finds user by id.
     *
     * @param id Id
     * @return Optional<User>
     */
    @Override
    public Optional<User> findById(final Long id) {
        return this.jdbcTemplate.query(
            DBQueries.USER_BY_ID,
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
     * Method creates user.
     *
     * @param user User
     * @return User
     */
    @Override
    protected User create(final User user) {
        var keyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(conn -> {
            var ps = conn.prepareStatement(
                DBQueries.CREATE_USER,
                Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            return ps;
        }, keyHolder);
        user.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return user;
    }

    /**
     * Method updates user.
     *
     * @param user User
     * @return User
     */
    @Override
    protected User update(final User user) {
        var params = new Object[]{user.getName(), user.getId()};
        var result = this.jdbcTemplate.update(DBQueries.UPDATE_USER, params);
        if (result == 1) {
            return user;
        } else {
            throw new RuntimeException("Exception caught while updating");
        }
    }

    /**
     * Method deletes user by id.
     *
     * @param id Id
     * @return boolean
     */
    @Override
    public boolean deleteById(final Long id) {
        var params = new Object[]{id};
        return this.jdbcTemplate.update(DBQueries.DELETE_USER, params) == 1;
    }
}
