package com.mishinyura.university.dao.impl;

import com.mishinyura.university.dao.mappers.TimeRowMapper;
import com.mishinyura.university.domain.Time;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class TimeDAOImplTest.
 * Tests com.mishinyura.university.dao.impl.TimeDAOImpl class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 31.08.2021
 */
@JdbcTest
@ActiveProfiles("test")
class TimeDAOImplTest {
    /**
     * JdbcTemplate.
     */
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * TimeDAOImpl.
     */
    private TimeDAOImpl timeDAO;

    /**
     * Before each test performs method.
     */
    @BeforeEach
    void setup() {
        timeDAO = new TimeDAOImpl(jdbcTemplate, new TimeRowMapper());
    }

    /**
     * Tests findAll() method.
     */
    @Test
    void shouldFindAllTimes() {
        // given

        // when
        var times = timeDAO.findAll();

        // then
        assertThat(times).hasSize(2);
        assertThat(times.get(0).getId()).isEqualTo(1);
        assertThat(times.get(0).getStart()).hasToString("08:00");
        assertThat(times.get(0).getEnd()).hasToString("08:40");
    }

    /**
     * Tests findById() method.
     */
    @Test
    void shouldFindById() {
        // given

        // when
        var time = timeDAO.findById(1L);

        // then
        assertThat(time.get().getStart()).hasToString("08:00");
        assertThat(time.get().getEnd()).hasToString("08:40");
    }

    /**
     * Tests findById() method.
     */
    @Test
    void shouldReturnEmptyWhenFindByWrongId() {
        // given

        // when
        var time = timeDAO.findById(10L);

        // then
        assertThat(time).isNotPresent();
    }

    /**
     * Tests save() method.
     */
    @Test
    void shouldSaveNewTime() {
        // given
        var newTime = new Time(LocalTime.parse("10:00"), LocalTime.parse("10:40"));

        // when
        var timeAdded = timeDAO.save(newTime);

        // then
        assertThat(timeAdded).isInstanceOf(Time.class);
        assertThat(timeAdded.getId()).isEqualTo(3L);
        assertThat(timeAdded.getStart()).hasToString("10:00");
        assertThat(timeAdded.getEnd()).hasToString("10:40");
    }

    /**
     * Tests save() method.
     */
    @Test
    void shouldUpdateTime() {
        // given
        var time = timeDAO.findById(1L).get();
        var timeToUpdate = new Time(
            time.getId(),
            LocalTime.parse("09:10"),
            LocalTime.parse("09:50"));

        // when
        var timeAdded = timeDAO.save(timeToUpdate);
        var timeFound = timeDAO.findById(1L).get();

        // then
        assertThat(timeAdded).isInstanceOf(Time.class);
        assertThat(timeFound.getStart())
            .hasToString(timeAdded.getStart().toString());
    }

    /**
     * Tests deleteById() method.
     */
    @Test
    void shouldDeleteTime() {
        // given
        var id = 1L;

        // when
        var result = timeDAO.deleteById(id);
        var time = timeDAO.findById(id);

        // then
        assertThat(result).isTrue();
        assertThat(time).isNotPresent();
    }

    /**
     * Tests deleteById() method.
     */
    @Test
    void shouldNotDeleteTimeWhenWrongId() {
        // given
        var id = 10L;

        // when
        var result = timeDAO.deleteById(id);

        // then
        assertThat(result).isFalse();
    }
}
