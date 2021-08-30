package com.mishinyura.university.dao.impl;

import com.mishinyura.university.domain.Group;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class GroupDAOImplTest.
 * Tests com.mishinyura.university.dao.impl.groupDAOImpl class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 30.08.2021
 */
@JdbcTest
@ComponentScan
@ActiveProfiles("test")
class GroupDAOImplTest {
    /**
     * GroupDAOImpl.
     */
    @Autowired
    private GroupDAOImpl groupDAO;

    /**
     * Tests findAll() method.
     */
    @Test
    void shouldFindAllGroups() {
        // given

        // when
        var groups = groupDAO.findAll();

        // then
        assertThat(groups).hasSize(1);
        assertThat(groups.get(0).getId()).isEqualTo(1);
        assertThat(groups.get(0).getName()).isEqualTo("Group1");
    }

    /**
     * Tests findById() method.
     */
    @Test
    void shouldFindById() {
        // given

        // when
        var group = groupDAO.findById(1L);

        // then
        assertThat(group.get().getName()).isEqualTo("Group1");
    }

    /**
     * Tests findById() method.
     */
    @Test
    void shouldReturnEmptyWhenFindByWrongId() {
        // given

        // when
        var group = groupDAO.findById(10L);

        // then
        assertThat(group).isNotPresent();
    }

    /**
     * Tests save() method.
     */
    @Test
    void shouldSaveNewGroup() {
        // given
        var newGroup = new Group("Group2");

        // when
        var groupAdded = groupDAO.save(newGroup);

        // then
        assertThat(groupAdded).isInstanceOf(Group.class);
        assertThat(groupAdded.getId()).isEqualTo(2L);
        assertThat(groupAdded.getName()).isEqualTo("Group2");
    }

    /**
     * Tests save() method.
     */
    @Test
    void shouldUpdateGroup() {
        // given
        var group = groupDAO.findById(1L).get();
        var groupToUpdate = new Group(group.getId(), "NewGroup");

        // when
        var groupAdded = groupDAO.save(groupToUpdate);
        var groupFound = groupDAO.findById(1L).get();

        // then
        assertThat(groupAdded).isInstanceOf(Group.class);
        assertThat(groupFound.getName()).isEqualTo(groupAdded.getName());
    }

    /**
     * Tests deleteById() method.
     */
    @Test
    void shouldDeleteGroup() {
        // given
        var id = 1L;

        // when
        var result = groupDAO.deleteById(id);
        var group = groupDAO.findById(id);

        // then
        assertThat(result).isTrue();
        assertThat(group).isNotPresent();
    }

    /**
     * Tests deleteById() method.
     */
    @Test
    void shouldNotDeleteGroupWhenWrongId() {
        // given
        var id = 10L;

        // when
        var result = groupDAO.deleteById(id);

        // then
        assertThat(result).isFalse();
    }
}
