/*
 * Created by Dmitry Scherbakov on 11.02.2020, 1:19
 */

/*
 * Created by Dmitry Scherbakov on 10.02.2020, 22:59
 */

package com.sda.hotel.backend.dao;

import java.util.List;

public interface AbstractDao<E, K> {
    List<E> getAll();

    E getEntityById(K id);

    E update(E entity);

    boolean delete(K id);

    boolean create(E entity);
}
