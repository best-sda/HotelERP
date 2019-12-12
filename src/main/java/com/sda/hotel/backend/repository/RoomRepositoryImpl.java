/*
 * Created by Dmitry Scherbakov in 09.12.2019, 15:25
 */

package com.sda.hotel.backend.repository;

import com.sda.hotel.backend.domain.Room;
import com.sda.hotel.backend.exeption.EntityNotFoundExeption;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoomRepositoryImpl implements RoomRepository {
    private List<Room> rooms = new ArrayList<>();
    @Override
    public Room save(Room guest) {
        rooms.add(guest);
        return guest;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List <Room> roomList() {
        return rooms;
    }

    @Override
    public Room roomWithId(Integer id) {
        return rooms.stream().filter(room -> room.getNumber().equals(id)).findFirst()
                .orElseThrow(EntityNotFoundExeption::new);
    }

    @Override
    public void setRoomBusy(Room room) {
        room.setBusy(true);
    }

    @Override
    public void chekoutGuest(Integer roomNumber) {
        rooms.get(roomNumber).setBusy(false);
    }
}
