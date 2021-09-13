package com.mishinyura.university.domain;

import java.util.Objects;

/**
 * Class Schedule.
 * Implements Schedule Entity.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.08.2021
 */
public class Schedule extends Entity<Long> {
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
    private Integer day;
    /**
     * Time.
     */
    private Time time;
    /**
     * Classroom.
     */
    private Classroom classroom;

    /**
     * Constructor.
     *
     * @param group     Group
     * @param subject   Subject
     * @param day       Day
     * @param time      Time
     * @param classroom Classroom
     */
    public Schedule(
        final Group group,
        final Subject subject,
        final Integer day,
        final Time time,
        final Classroom classroom
    ) {
        this.group = group;
        this.subject = subject;
        this.day = day;
        this.time = time;
        this.classroom = classroom;
    }

    /**
     * Constructor.
     *
     * @param id        Id
     * @param group     Group
     * @param subject   SUBJECT
     * @param day       Day
     * @param time      Time
     * @param classroom Classroom
     */
    public Schedule(
        final Long id,
        final Group group,
        final Subject subject,
        final Integer day,
        final Time time,
        final Classroom classroom
    ) {
        this.id = id;
        this.group = group;
        this.subject = subject;
        this.day = day;
        this.time = time;
        this.classroom = classroom;
    }

    /**
     * @return Group
     */
    public Group getGroup() {
        return group;
    }

    /**
     * @param group Group
     */
    public void setGroup(final Group group) {
        this.group = group;
    }

    /**
     * @return Subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * @param subject Subject
     */
    public void setSubject(final Subject subject) {
        this.subject = subject;
    }

    /**
     * @return Day
     */
    public Integer getDay() {
        return day;
    }

    /**
     * @param day Day
     */
    public void setDay(final Integer day) {
        this.day = day;
    }

    /**
     * @return Time
     */
    public Time getTime() {
        return time;
    }

    /**
     * @param time Time
     */
    public void setTime(final Time time) {
        this.time = time;
    }

    /**
     * @return Classroom
     */
    public Classroom getClassroom() {
        return classroom;
    }

    /**
     * @param classroom Classroom
     */
    public void setClassroom(final Classroom classroom) {
        this.classroom = classroom;
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
