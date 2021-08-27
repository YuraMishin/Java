package com.mishinyura.university.domain;

import java.util.Objects;

/**
 * Class Schedule.
 * Implements Schedule Entity.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.08.2021
 */
public class Schedule {
    /**
     * Id.
     */
    private Long id;
    /**
     * Group.
     */
    private Group group;
    /**
     * Subject.
     */
    private Subject subject;
    /**
     * Day.
     */
    private byte day;
    /**
     * Time.
     */
    private Time time;
    /**
     * Classroom.
     */
    private Classroom classroom;
    /**
     * Role.
     */
    private Role role;

    /**
     * Constructor.
     */
    public Schedule() {
    }

    /**
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var subject = (Schedule) o;
        return Objects.equals(id, subject.id);
    }

    /**
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
