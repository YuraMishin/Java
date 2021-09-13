package com.mishinyura.university.dao.impl;

import com.mishinyura.university.dao.mappers.*;
import com.mishinyura.university.domain.Schedule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class ScheduleDAOImplTest.
 * Tests com.mishinyura.university.dao.impl.ScheduleDAOImpl class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 31.08.2021
 */
@JdbcTest
@ActiveProfiles("test")
class ScheduleDAOImplTest {
    /**
     * JdbcTemplate.
     */
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * ScheduleDAOImpl.
     */
    private ScheduleDAOImpl scheduleDAO;
    private GroupDAOImpl groupDAO;
    private SubjectDAOImpl subjectDAO;
    private TimeDAOImpl timeDAO;
    private ClassroomDAOImpl classroomDAO;

    /**
     * Before each test performs method.
     */
    @BeforeEach
    void setup() {
        groupDAO = new GroupDAOImpl(jdbcTemplate, new GroupRowMapper());
        subjectDAO = new SubjectDAOImpl(jdbcTemplate, new SubjectRowMapper());
        timeDAO = new TimeDAOImpl(jdbcTemplate, new TimeRowMapper());
        classroomDAO = new ClassroomDAOImpl(jdbcTemplate, new ClassroomRowMapper());
        scheduleDAO = new ScheduleDAOImpl(jdbcTemplate, new ScheduleRowMapper(groupDAO, subjectDAO, timeDAO, classroomDAO));
    }

    /**
     * Tests findAll() method.
     */
    @Test
    void shouldFindAllSubjects() {
        // given

        // when
        var list = scheduleDAO.findAll();

        // then
        assertThat(list).hasSize(1);
        assertThat(list.get(0).getGroup().getName()).isEqualTo("Group1");
        assertThat(list.get(0).getSubject().getName()).isEqualTo("Subject1");
        assertThat(list.get(0).getDay()).isEqualTo(1);
        assertThat(list.get(0).getTime().getStart()).hasToString("08:00");
        assertThat(list.get(0).getTime().getEnd()).hasToString("08:40");
        assertThat(list.get(0).getClassroom().getName()).isEqualTo("Classroom1");
    }

    /**
     * Tests findById() method.
     */
    @Test
    void shouldFindById() {
        // given

        // when
        var record = scheduleDAO.findById(1L);

        // then
        assertThat(record.get().getGroup().getName()).isEqualTo("Group1");
        assertThat(record.get().getSubject().getName()).isEqualTo("Subject1");
        assertThat(record.get().getDay()).isEqualTo(1);
        assertThat(record.get().getTime().getStart()).hasToString("08:00");
        assertThat(record.get().getTime().getEnd()).hasToString("08:40");
        assertThat(record.get().getClassroom().getName()).isEqualTo("Classroom1");
    }

    /**
     * Tests findById() method.
     */
    @Test
    void shouldReturnEmptyWhenFindByWrongId() {
        // given

        // when
        var user = scheduleDAO.findById(10L);

        // then
        assertThat(user).isNotPresent();
    }

    /**
     * Tests save() method.
     */
    @Test
    void shouldSaveNewScheduleRecord() {
        // given
        var group = groupDAO.findById(1L).get();
        var subject = subjectDAO.findById(1L).get();
        var time = timeDAO.findById(1L).get();
        var classroom = classroomDAO.findById(1L).get();
        var newRecord = new Schedule(
            group,
            subject,
            1,
            time,
            classroom
        );

        // when
        var recordAdded = scheduleDAO.save(newRecord);

        // then
        assertThat(recordAdded).isInstanceOf(Schedule.class);
        assertThat(recordAdded.getId()).isEqualTo(2L);
        assertThat(recordAdded.getGroup().getName()).isEqualTo(group.getName());
        assertThat(recordAdded.getSubject().getName()).isEqualTo(subject.getName());
        assertThat(recordAdded.getDay()).isEqualTo(1);
        assertThat(recordAdded.getTime().getStart()).hasToString("08:00");
        assertThat(recordAdded.getTime().getEnd()).hasToString("08:40");
        assertThat(recordAdded.getClassroom().getName()).isEqualTo("Classroom1");
    }

    /**
     * Tests save() method.
     */
    @Test
    void shouldUpdateSchedule() {
        // given
        var record = scheduleDAO.findById(1L).get();
        var group = groupDAO.findById(2L).get();
        var subject = subjectDAO.findById(2L).get();
        var time = timeDAO.findById(2L).get();
        var classroom = classroomDAO.findById(2L).get();
        var recordToUpdate = new Schedule(
            record.getId(),
            group,
            subject,
            2,
            time,
            classroom
        );

        // when
        var recordAdded = scheduleDAO.save(recordToUpdate);
        var recordFound = scheduleDAO.findById(1L).get();

        // then
        assertThat(recordAdded).isInstanceOf(Schedule.class);
        assertThat(recordFound.getGroup().getName())
            .isEqualTo(group.getName());
        assertThat(recordAdded.getSubject().getName())
            .isEqualTo(subject.getName());
        assertThat(recordAdded.getDay())
            .isEqualTo(recordToUpdate.getDay());
        assertThat(recordAdded.getTime().getStart()).hasToString("09:00");
        assertThat(recordAdded.getTime().getEnd()).hasToString("09:40");
        assertThat(recordAdded.getClassroom().getName()).isEqualTo("Classroom2");
    }

    /**
     * Tests deleteById() method.
     */
    @Test
    void shouldDeleteScheduleRecord() {
        // given
        var id = 1L;

        // when
        var result = scheduleDAO.deleteById(id);
        var user = scheduleDAO.findById(id);

        // then
        assertThat(result).isTrue();
        assertThat(user).isNotPresent();
    }

    /**
     * Tests deleteById() method.
     */
    @Test
    void shouldNotDeleteScheduleRecordWhenWrongId() {
        // given
        var id = 10L;

        // when
        var result = scheduleDAO.deleteById(id);

        // then
        assertThat(result).isFalse();
    }
}
