/*
 * Created by Dmitry Scherbakov in 09.12.2019, 15:22
 */

package com.sda.hotel.backend.service;

import com.sda.hotel.backend.domain.Room;
import com.sda.hotel.backend.repository.RoomRepository;
import com.sda.hotel.backend.repository.RoomRepositoryImpl;

import java.util.List;

public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository = new RoomRepositoryImpl();

    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List <Room> roomList() {
        return roomRepository.roomList();
    }

    @Override
    public void delete(int id) {
        roomRepository.delete(id);
    }

    @Override
    public List <Room> showRooms() {
        return null;
    }

    @Override
    public Room roomWithId(int id) {
        return roomRepository.roomWithId(id);
    }

    @Override
    public void setRoomBusy(Room room) {
        roomRepository.setRoomBusy(room);
    }

    @Override
    public void chekoutGuest(Integer guestId) {
        roomRepository.chekoutGuest(guestId);
    }

    @Override
    public void loadList() {
        roomRepository.loadList();
    }

    @Override
    public void saveList() {
        roomRepository.saveList();
    }
}
