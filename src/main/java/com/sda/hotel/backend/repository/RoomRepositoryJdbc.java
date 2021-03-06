/*
 * Created by Dmitry Scherbakov on 11.02.2020, 13:33
 */

package com.sda.hotel.backend.repository;

import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.dao.GuestDao;
import com.sda.hotel.backend.dao.OrderDao;
import com.sda.hotel.backend.dao.RoomDao;
import com.sda.hotel.backend.domain.Room;

import java.util.List;

public class RoomRepositoryJdbc implements RoomRepository {
    @Autowired
    RoomDao roomDao;
    @Autowired
    OrderDao orderDao;
    @Override
    public Room save(Room guest) {
        return null;
    }

    @Override
    public void delete(int id) {
        roomDao.delete(id);
    }

    @Override
    public List<Room> roomList() {
        return roomDao.getAll();
    }

    @Override
    public Room roomWithId(Integer id) {
        return roomDao.getEntityById(id);
    }

    @Override
    public void setRoomBusy(Room room) {
        roomDao.update(room);
    }

    @Override
    public void saveList() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadList() {
        throw new UnsupportedOperationException();
    }
}
