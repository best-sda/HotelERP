/*
 * Created by Dmitry Scherbakov on 11.02.2020, 1:23
 */

package com.sda.hotel.backend.dao;

import com.sda.hotel.backend.domain.Room;

import java.util.List;

public class RoomDao<E, K> extends AbstractDaoImpl<Room, Integer> {
    @Override
    public List<Room> getAll() {
        return null;
    }

    @Override
    public Room getEntityById(Integer id) {
        return null;
    }

    @Override
    public Room update(Room entity) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(Room entity) {
        return false;
    }
}
