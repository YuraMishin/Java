package com.mishinyura.university.domain;

/**
 * Class Entity.
 * Implements entity.
 *
 * @param <K> Key
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 02.08.2021
 */
public class Entity<K> {
    /**
     * Id.
     */
    protected K id;

    /**
     * @return Id
     */
    public K getId() {
        return id;
    }

    /**
     * @param id Id
     */
    public void setId(final K id) {
        this.id = id;
    }
}
