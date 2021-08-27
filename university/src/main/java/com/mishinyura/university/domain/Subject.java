package com.mishinyura.university.domain;

import java.util.Objects;

/**
 * Class Subject.
 * Implements Subject Entity.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 24.08.2021
 */
public class Subject {
    /**
     * Id.
     */
    private Long id;
    /**
     * Name.
     */
    private String name;

    /**
     * Constructor.
     */
    public Subject() {
    }

    /**
     * Constructor.
     *
     * @param name Name
     */
    public Subject(final String name) {
        this.name = name;
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id id
     */
    public void setId(final Long id) {
        this.id = id;
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
        var subject = (Subject) o;
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
        return "Subject{"
            + "id=" + id
            + ", name='" + name + '\'' + '}';
    }
}