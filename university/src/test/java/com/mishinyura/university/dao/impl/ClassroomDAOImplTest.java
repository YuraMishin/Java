package com.mishinyura.university.dao.impl;

import com.mishinyura.university.dao.mappers.ClassroomRowMapper;
import com.mishinyura.university.domain.Classroom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class ClassroomDAOImplTest.
 * Tests com.mishinyura.university.dao.impl.ClassroomDAOImpl class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 30.08.2021
 */
@JdbcTest
@ActiveProfiles("test")
class ClassroomDAOImplTest {
    /**
     * JdbcTemplate.
     */
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * ClassroomDAOImpl.
     */
    private ClassroomDAOImpl classroomDAO;

    /**
     * Before each test performs method.
     */
    @BeforeEach
    void setup() {
        classroomDAO = new ClassroomDAOImpl(jdbcTemplate, new ClassroomRowMapper());
    }

    /**
     * Tests findAll() method.
     */
    @Test
    void shouldFindAllClassrooms() {
        // given

        // when
        var classrooms = classroomDAO.findAll();

        // then
        assertThat(classrooms).hasSize(2);
        assertThat(classrooms.get(0).getId()).isEqualTo(1);
        assertThat(classrooms.get(0).getName()).isEqualTo("Classroom1");
    }

    /**
     * Tests findById() method.
     */
    @Test
    void shouldFindById() {
        // given

        // when
        var classroom = classroomDAO.findById(1L);

        // then
        assertThat(classroom.get().getName()).isEqualTo("Classroom1");
    }

    /**
     * Tests findById() method.
     */
    @Test
    void shouldReturnEmptyWhenFindByWrongId() {
        // given

        // when
        var classroom = classroomDAO.findById(10L);

        // then
        assertThat(classroom).isNotPresent();
    }

    /**
     * Tests save() method.
     */
    @Test
    void shouldSaveNewClassroom() {
        // given
        var newClassroom = new Classroom("Classroom3");

        // when
        var classroomAdded = classroomDAO.save(newClassroom);

        // then
        assertThat(classroomAdded).isInstanceOf(Classroom.class);
        assertThat(classroomAdded.getId()).isEqualTo(3L);
        assertThat(classroomAdded.getName()).isEqualTo("Classroom3");
    }

    /**
     * Tests save() method.
     */
    @Test
    void shouldUpdateClassroom() {
        // given
        var classroom = classroomDAO.findById(1L).get();
        var classroomToUpdate = new Classroom(classroom.getId(), "NewClassroom");

        // when
        var classroomAdded = classroomDAO.save(classroomToUpdate);
        var classroomfound = classroomDAO.findById(1L).get();

        // then
        assertThat(classroomAdded).isInstanceOf(Classroom.class);
        assertThat(classroomfound.getName()).isEqualTo(classroomAdded.getName());
    }

    /**
     * Tests deleteById() method.
     */
    @Test
    void shouldDeleteClassroom() {
        // given
        var id = 1L;

        // when
        var result = classroomDAO.deleteById(id);
        var classroom = classroomDAO.findById(id);

        // then
        assertThat(result).isTrue();
        assertThat(classroom).isNotPresent();
    }

    /**
     * Tests deleteById() method.
     */
    @Test
    void shouldNotDeleteClassroomWhenWrongId() {
        // given
        var id = 10L;

        // when
        var result = classroomDAO.deleteById(id);

        // then
        assertThat(result).isFalse();
    }
}
