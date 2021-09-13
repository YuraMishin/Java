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
public class Time extends Entity<Long> {
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
     *
     * @param start Start time
     * @param end   End time
     */
    public Time(final LocalTime start, final LocalTime end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Constructor.
     *
     * @param id    Id
     * @param start Start time
     * @param end   End time
     */
    public Time(final Long id, final LocalTime start, final LocalTime end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    /**
     * @return start
     */
    public LocalTime getStart() {
        return start;
    }

    /**
     * @param start start
     */
    public void setStart(final LocalTime start) {
        this.start = start;
    }

    /**
     * @return end
     */
    public LocalTime getEnd() {
        return end;
    }

    /**
     * @param end end
     */
    public void setEnd(final LocalTime end) {
        this.end = end;
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
