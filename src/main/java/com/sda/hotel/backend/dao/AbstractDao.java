/*
 * Created by Dmitry Scherbakov on 11.02.2020, 1:19
 */

/*
 * Created by Dmitry Scherbakov on 10.02.2020, 22:59
 */

package com.sda.hotel.backend.dao;

import java.util.List;

public interface AbstractDao<E, K> {
    public abstract List<E> getAll();
    public abstract E getEntityById(K id);
    public abstract E update(E entity);
    public abstract boolean delete(K id);
    public abstract boolean create(E entity);
}
