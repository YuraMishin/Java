package com.mishinyura.university.domain;

import java.util.Objects;

/**
 * Class Classroom.
 * Implements Classroom Entity.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.08.2021
 */
public class Classroom extends Entity<Long> {
    /**
     * Name.
     */
    private String name;

    /**
     * Constructor.
     *
     * @param name Name
     */
    public Classroom(final String name) {
        this.name = name;
    }

    /**
     * Constructor.
     *
     * @param id   Id
     * @param name Name
     */
    public Classroom(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name name
     */
    public void setName(final String name) {
        this.name = name;
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
        var subject = (Classroom) o;
        return Objects.equals(id, subject.id);
    }

    /**
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Classroom{"
            + "id=" + id
            + ", name='" + name + '\'' + '}';
    }
}
