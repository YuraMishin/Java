package com.mishinyura.university.dao.impl;

import com.mishinyura.university.dao.GroupDAO;
import com.mishinyura.university.dao.mappers.GroupRM;
import com.mishinyura.university.domain.Group;
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
 * Class GroupDAOImpl.
 * Implements GroupDAO.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 30.08.2021
 */
@Repository
public class GroupDAOImpl extends AbstractCrudDAO<Group, Long>
    implements GroupDAO {
    /**
     * JdbcTemplate.
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * GroupRM.
     */
    @Autowired
    private GroupRM groupRM;

    /**
     * Method finds all groups.
     *
     * @return List<Group>
     */
    public List<Group> findAll() {
        return this.jdbcTemplate.query(
            DBQueries.ALL_GROUPS, groupRM
        );
    }

    /**
     * Method finds Group by id.
     *
     * @param id Id
     * @return Optional<Group>
     */
    @Override
    public Optional<Group> findById(final Long id) {
        return this.jdbcTemplate.query(
            DBQueries.GROUP_BY_ID,
            rs -> {
                if (rs.next()) {
                    return Optional.ofNullable(groupRM.mapRow(rs, 1));
                } else {
                    return Optional.empty();
                }
            },
            id
        );
    }

    /**
     * Method deletes Group by id.
     *
     * @param id Id
     * @return boolean
     */
    @Override
    public boolean deleteById(final Long id) {
        var params = new Object[]{id};
        return this.jdbcTemplate.update(DBQueries.DELETE_GROUP, params) == 1;
    }

    /**
     * Method creates group.
     *
     * @param group group
     * @return group
     */
    @Override
    protected Group create(final Group group) {
        var keyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(conn -> {
            var ps = conn.prepareStatement(
                DBQueries.CREATE_GROUP,
                Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, group.getName());
            return ps;
        }, keyHolder);
        group.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        return group;
    }

    /**
     * Method updates group.
     *
     * @param group group
     * @return group
     */
    @Override
    protected Group update(final Group group) {
        var params = new Object[]{group.getName(), group.getId()};
        var result = this.jdbcTemplate.update(DBQueries.UPDATE_GROUP, params);
        if (result == 1) {
            return group;
        } else {
            throw new RuntimeException("Exception caught while updating");
        }
    }
}
