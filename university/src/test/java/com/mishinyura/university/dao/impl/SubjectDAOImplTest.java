package com.mishinyura.university.dao.impl;

import com.mishinyura.university.domain.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Class SubjectDAOImplTest.
 * Tests com.mishinyura.university.dao.impl.SubjectDAOImpl class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 30.08.2021
 */
@JdbcTest
@ComponentScan
@ActiveProfiles("test")
class SubjectDAOImplTest {
    /**
     * SubjectDAOImpl.
     */
    @Autowired
    private SubjectDAOImpl subjectDAO;

    /**
     * Tests findAll() method.
     */
    @Test
    void shouldFindAllSubjects() {
        // given

        // when
        var subjects = subjectDAO.findAll();

        // then
        assertThat(subjects).hasSize(1);
        assertThat(subjects.get(0).getId()).isEqualTo(1);
        assertThat(subjects.get(0).getName()).isEqualTo("Subject1");
    }

    /**
     * Tests findById() method.
     */
    @Test
    void shouldFindById() {
        // given

        // when
        var subject = subjectDAO.findById(1L);

        // then
        assertThat(subject.get().getName()).isEqualTo("Subject1");
    }

    /**
     * Tests findById() method.
     */
    @Test
    void shouldReturnEmptyWhenFindByWrongId() {
        // given

        // when
        var subject = subjectDAO.findById(10L);

        // then
        assertThat(subject).isNotPresent();
    }

    /**
     * Tests save() method.
     */
    @Test
    void shouldSaveNewSubject() {
        // given
        var newSubject = new Subject("Subject2");

        // when
        var subjectAdded = subjectDAO.save(newSubject);

        // then
        assertThat(subjectAdded).isInstanceOf(Subject.class);
        assertThat(subjectAdded.getId()).isEqualTo(2L);
        assertThat(subjectAdded.getName()).isEqualTo("Subject2");
    }

    /**
     * Tests save() method.
     */
    @Test
    void shouldUpdateSubject() {
        // given
        var subject = subjectDAO.findById(1L).get();
        var subjectToUpdate = new Subject(subject.getId(), "NewSubject");

        // when
        var subjectAdded = subjectDAO.save(subjectToUpdate);
        var subjectFound = subjectDAO.findById(1L).get();

        // then
        assertThat(subjectAdded).isInstanceOf(Subject.class);
        assertThat(subjectFound.getName()).isEqualTo(subjectAdded.getName());
    }

    /**
     * Tests deleteById() method.
     */
    @Test
    void shouldDeleteSubject() {
        // given
        var id = 1L;

        // when
        var result = subjectDAO.deleteById(id);
        var subject = subjectDAO.findById(id);

        // then
        assertThat(result).isTrue();
        assertThat(subject).isNotPresent();
    }

    /**
     * Tests deleteById() method.
     */
    @Test
    void shouldNotDeleteSubjectWhenWrongId() {
        // given
        var id = 10L;

        // when
        var result = subjectDAO.deleteById(id);

        // then
        assertThat(result).isFalse();
    }
}
