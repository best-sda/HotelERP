/*
 * Created by Dmitry Scherbakov on 11.02.2020, 13:33
 */

package com.sda.hotel.backend.repository;

import com.sda.hotel.backend.domain.Room;

import java.util.List;

public class RoomRepositoryJdbc implements RoomRepository {
    @Override
    public Room save(Room guest) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Room> roomList() {
        return null;
    }

    @Override
    public Room roomWithId(Integer id) {
        return null;
    }

    @Override
    public void setRoomBusy(Room room) {

    }

    @Override
    public void chekoutGuest(Integer guestId) {

    }

    @Override
    public void saveList() {

    }

    @Override
    public void loadList() {

    }
}
