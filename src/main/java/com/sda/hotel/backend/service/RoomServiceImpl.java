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
    private RoomRepository roomRepositoryImpl;

    public RoomRepository getRoomRepositoryImpl() {
        return roomRepositoryImpl;
    }

    public void setRoomRepositoryImpl(RoomRepository roomRepositoryImpl) {
        this.roomRepositoryImpl = roomRepositoryImpl;
    }

    @Override
    public Room save(Room room) {
        return roomRepositoryImpl.save(room);
    }

    @Override
    public List<Room> roomList() {
        return roomRepositoryImpl.roomList();
    }

    @Override
    public void delete(int id) {
        roomRepositoryImpl.delete(id);
    }

    @Override
    public List<Room> showRooms() {
        return null;
    }

    @Override
    public Room roomWithId(int id) {
        return roomRepositoryImpl.roomWithId(id);
    }

    @Override
    public void setRoomBusy(Room room) {
        roomRepositoryImpl.setRoomBusy(room);
    }

    @Override
    public void chekoutGuest(Integer guestId) {
        roomRepositoryImpl.chekoutGuest(guestId);
    }

    @Override
    public void loadList() {
        roomRepositoryImpl.loadList();
    }

    @Override
    public void saveList() {
        roomRepositoryImpl.saveList();
    }
}
