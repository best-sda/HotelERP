/*
 * Created by Dmitry Scherbakov in 09.12.2019, 15:22
 */

package com.sda.hotel.backend.service;

import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.domain.Room;
import com.sda.hotel.backend.repository.RoomRepository;

import java.util.List;

@Component
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepositoryJdbc;

    public RoomRepository getRoomRepositoryJdbc() {
        return roomRepositoryJdbc;
    }

    public void setRoomRepositoryJdbc(RoomRepository roomRepositoryJdbc) {
        this.roomRepositoryJdbc = roomRepositoryJdbc;
    }

    @Override
    public Room save(Room room) {
        return roomRepositoryJdbc.save(room);
    }

    @Override
    public List<Room> roomList() {
        return roomRepositoryJdbc.roomList();
    }

    @Override
    public void delete(int id) {
        roomRepositoryJdbc.delete(id);
    }

    @Override
    public List<Room> showRooms() {
        return null;
    }

    @Override
    public Room roomWithId(int id) {
        return roomRepositoryJdbc.roomWithId(id);
    }

    @Override
    public void setRoomBusy(Room room) {
        roomRepositoryJdbc.setRoomBusy(room);
    }

    @Override
    public void chekoutGuest(Integer guestId) {
    }

    @Override
    public void loadList() {
        roomRepositoryJdbc.loadList();
    }

    @Override
    public void saveList() {
        roomRepositoryJdbc.saveList();
    }
}
