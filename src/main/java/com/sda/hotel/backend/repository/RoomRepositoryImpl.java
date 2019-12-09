/*
 * Created by Dmitry Scherbakov in 09.12.2019, 15:25
 */

package com.sda.hotel.backend.repository;

import com.sda.hotel.backend.domain.Room;

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
}
