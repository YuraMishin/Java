package com.mishinyura.university.domain;

import java.time.LocalTime;
import java.util.Objects;

/**
 * Class Time.
 * Implements Time Entity.
 *
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 27.08.2021
 */
public class Time {
    /**
     * Id.
     */
    private Long id;
    /**
     * Start.
     */
    private LocalTime start;
    /**
     * End.
     */
    private LocalTime end;

    /**
     * Constructor.
     */
    public Time() {
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
        var subject = (Time) o;
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
