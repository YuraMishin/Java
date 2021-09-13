package com.mishinyura.university.services.impl;

import com.mishinyura.university.dao.SubjectDAO;
import com.mishinyura.university.domain.Subject;
import com.mishinyura.university.services.SubjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Class SubjectServiceImplTest.
 * Tests com.mishinyura.university.services.impl.SubjectServiceImpl class.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 05.09.2021
 */
@SpringBootTest(classes = SubjectServiceImpl.class)
class SubjectServiceImplTest {
    /**
     * SubjectDAO.
     */
    @MockBean
    SubjectDAO subjectDAO;

    /**
     * SubjectService.
     */
    @Autowired
    SubjectService subjectService;

    /**
     * Subjects.
     */
    private final List<Subject> mockSubjects = new ArrayList<>();

    @BeforeEach
    void setup() {
        Collections.addAll(mockSubjects,
            new Subject(1L, "Subject1"),
            new Subject(2L, "Subject2")
        );
    }

    /**
     * Tests findAll() method.
     */
    @Test
    void shouldFindAllSubjects() {
        // given
        when(subjectDAO.findAll()).thenReturn(mockSubjects);

        //when
        var subjects = subjectService.findAll();

        // then
        assertThat(subjects)
            .isInstanceOf(ArrayList.class)
            .hasSize(2);
        assertThat(subjects.get(0).getId()).isEqualTo(1);
        assertThat(subjects.get(0).getName()).isEqualTo("Subject1");

        verify(subjectDAO, times(1)).findAll();
    }

    /**
     * Tests findById() method.
     */
    @Test
    void shouldFindById() {
        // given
        var id = 1L;
        when(subjectDAO.findById(id)).thenReturn(Optional.ofNullable(mockSubjects.get(0)));

        // when
        var subject = subjectService.findById(id);

        // then
        assertThat(subject.get().getName()).isEqualTo("Subject1");

        verify(subjectDAO, times(1)).findById(id);
    }

    /**
     * Tests findById() method.
     */
    @Test
    void shouldReturnEmptyWhenFindByWrongId() {
        // given
        var id = 10L;
        when(subjectDAO.findById(id)).thenReturn(Optional.empty());

        // when
        var subject = subjectService.findById(id);

        // then
        assertThat(subject).isNotPresent();

        verify(subjectDAO, times(1)).findById(id);
    }

    /**
     * Tests save() method.
     */
    @Test
    void shouldSaveNewSubject() {
        // given
        var newSubject = new Subject("Subject3");
        when(subjectDAO.save(newSubject))
            .thenReturn(new Subject(3L, newSubject.getName()));

        // when
        var subjectAdded = subjectService.save(newSubject);

        // then
        assertThat(subjectAdded).isInstanceOf(Subject.class);
        assertThat(subjectAdded.getId()).isEqualTo(3L);
        assertThat(subjectAdded.getName()).isEqualTo("Subject3");

        verify(subjectDAO, times(1)).save(newSubject);
    }

    /**
     * Tests save() method.
     */
    @Test
    void shouldUpdateSubject() {
        // given
        var subjectToUpdate = new Subject(1L, "Subject1New");
        when(subjectDAO.save(subjectToUpdate))
            .thenReturn(new Subject(1L, subjectToUpdate.getName()));

        // when
        var subjectUpdated = subjectService.save(subjectToUpdate);

        // then
        assertThat(subjectUpdated).isInstanceOf(Subject.class);
        assertThat(subjectUpdated.getId()).isEqualTo(1L);
        assertThat(subjectUpdated.getName()).isEqualTo("Subject1New");

        verify(subjectDAO, times(1)).save(subjectToUpdate);
    }

    /**
     * Tests deleteById() method.
     */
    @Test
    void shouldDeleteSubject() {
        // given
        var id = 1L;
        when(subjectDAO.deleteById(id)).thenReturn(true);
        when(subjectDAO.findById(id)).thenReturn(Optional.empty());

        // when
        var result = subjectService.deleteById(id);
        var subject = subjectService.findById(id);

        // then
        assertThat(result).isTrue();
        assertThat(subject).isNotPresent();

        verify(subjectDAO, times(1)).deleteById(id);
        verify(subjectDAO, times(1)).findById(id);
    }

    /**
     * Tests deleteById() method.
     */
    @Test
    void shouldNotDeleteSubjectWhenWrongId() {
        // given
        var id = 10L;
        when(subjectDAO.deleteById(id)).thenReturn(false);

        // when
        var result = subjectService.deleteById(id);

        // then
        assertThat(result).isFalse();

        verify(subjectDAO, times(1)).deleteById(id);
    }
}
