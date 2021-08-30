package com.mishinyura.university.dao.impl;

import com.mishinyura.university.dao.CrudDAO;
import com.mishinyura.university.domain.Entity;

/**
 * Class AbstractCrudDAO.
 * Declares AbstractCrudDAO.
 *
 * @param <K> Key
 * @param <T> Entity
 * @author Mishin Yura (mishin.inbox@gmail.com)
 * @since 29.08.2021
 */
public abstract class AbstractCrudDAO<T extends Entity<K>, K>
    implements CrudDAO<T, K> {
    /**
     * Method saves entity.
     *
     * @param entity Entity
     * @return Entity
     */
    @Override
    public T save(final T entity) {
        return entity.getId() == null
            ? create(entity) : update(entity);
    }

    /**
     * Method creates entity.
     *
     * @param entity Entity
     * @return Entity
     */
    protected abstract T create(T entity);

    /**
     * Method updates entity.
     *
     * @param entity Entity
     * @return Entity
     */
    protected abstract T update(T entity);
}
