package com.mishinyura.university.domain;

import java.util.Objects;

/**
 * Class Group.
 * Implements Group Entity.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.08.2021
 */
public class Group {
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
    public Group() {
    }

    /**
     * Constructor.
     *
     * @param name Name
     */
    public Group(final String name) {
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
        var subject = (Group) o;
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
