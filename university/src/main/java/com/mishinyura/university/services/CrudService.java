package com.mishinyura.university.services;

import com.mishinyura.university.domain.Entity;

import java.util.List;
import java.util.Optional;

/**
 * Interface CrudService.
 * Declares Crud Service.
 *
 * @param <K> Key
 * @param <T> Entity
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 05.09.2021
 */
public interface CrudService<T extends Entity<K>, K> {
    /**
     * Method finds all entities.
     *
     * @return List<T>
     */
    List<T> findAll();

    /**
     * Method finds entity by id.
     *
     * @param id Id
     * @return Optional<Entity>
     */
    Optional<T> findById(K id);

    /**
     * Method saves entity.
     *
     * @param entity Entity
     * @return Entity
     */
    T save(T entity);

    /**
     * Method deletes entity by id.
     *
     * @param id Id
     * @return boolean
     */
    boolean deleteById(K id);
}
