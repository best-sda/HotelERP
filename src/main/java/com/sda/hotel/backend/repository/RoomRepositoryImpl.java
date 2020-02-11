/*
 * Created by Dmitry Scherbakov in 09.12.2019, 15:25
 */

package com.sda.hotel.backend.repository;

import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.domain.Room;
import com.sda.hotel.backend.exeption.EntityNotFoundExeption;
import com.sda.hotel.backend.utils.JsonSerialization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoomRepositoryImpl implements RoomRepository, Serializable {
    private List<Room> rooms = new ArrayList<>();

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room save(Room guest) {
        rooms.add(guest);
        return guest;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Room> roomList() {
        return rooms;
    }

    @Override
    public Room roomWithId(Integer id) {
        return rooms.stream().filter(room ->
                room.getId().equals(id)).findFirst()
                .orElseThrow(EntityNotFoundExeption::new);
    }

    @Override
    public void setRoomBusy(Room room) {
        room.setBusy(true);
    }

    @Override
    public void saveList() {
        JsonSerialization.saveList("roomList.txt", roomList());
    }

    @Override
    public void loadList() {
        JsonSerialization.loadList("roomList.txt");
    }

}
