package com.mishinyura.university.dao.impl;

import com.mishinyura.university.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class UserDAOImplTest.
 * Tests com.mishinyura.university.dao.impl.UserDAOImpl class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 28.08.2021
 */
@JdbcTest
@ComponentScan
@ActiveProfiles("test")
class UserDAOImplTest {
    /**
     * UserDAOImpl.
     */
    @Autowired
    private UserDAOImpl userDAO;

    /**
     * Tests findAll() method.
     */
    @Test
    void shouldFindAllStudents() {
        // given

        // when
        var users = userDAO.findAll();

        // then
        assertThat(users).hasSize(1);
        assertThat(users.get(0).getId()).isEqualTo(1);
        assertThat(users.get(0).getName()).isEqualTo("User1");
    }

    /**
     * Tests findById() method.
     */
    @Test
    void shouldFindById() {
        // given

        // when
        var user = userDAO.findById(1L);

        // then
        assertThat(user.get().getName()).isEqualTo("User1");
    }

    /**
     * Tests findById() method.
     */
    @Test
    void shouldReturnEmptyWhenFindByWrongId() {
        // given

        // when
        var user = userDAO.findById(10L);

        // then
        assertThat(user).isNotPresent();
    }

    /**
     * Tests save() method.
     */
    @Test
    void shouldSaveNewUser() {
        // given
        var newUser = new User("User2");

        // when
        var userAdded = userDAO.save(newUser);

        // then
        assertThat(userAdded).isInstanceOf(User.class);
        assertThat(userAdded.getId()).isEqualTo(2L);
        assertThat(userAdded.getName()).isEqualTo("User2");
    }

    /**
     * Tests save() method.
     */
    @Test
    void shouldUpdateUser() {
        // given
        var user = userDAO.findById(1L).get();
        var userToUpdate = new User(user.getId(), "NewName");

        // when
        var userAdded = userDAO.save(userToUpdate);
        var userFound = userDAO.findById(1L).get();

        // then
        assertThat(userAdded).isInstanceOf(User.class);
        assertThat(userFound.getName()).isEqualTo(userAdded.getName());
    }

    /**
     * Tests deleteById() method.
     */
    @Test
    void shouldDeleteUser() {
        // given
        var id = 1L;

        // when
        var result = userDAO.deleteById(id);
        var user = userDAO.findById(id);

        // then
        assertThat(result).isTrue();
        assertThat(user).isNotPresent();
    }

    /**
     * Tests deleteById() method.
     */
    @Test
    void shouldNotDeleteUserWhenWrongId() {
        // given
        var id = 10L;

        // when
        var result = userDAO.deleteById(id);

        // then
        assertThat(result).isFalse();
    }
}
