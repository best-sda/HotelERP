/*
 * Created by Dmitry Scherbakov in 09.12.2019, 15:22
 */

package com.sda.hotel.backend.service;

import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.domain.Room;

import java.util.List;

@Component
public interface RoomService {
    Room save(Room room);

    List <Room> roomList();

    void delete(int id);

    List <Room> showRooms();

    Room roomWithId(int id);

    void setRoomBusy(Room room);

    void chekoutGuest(Integer guestId);

    void loadList();

    void saveList();

}
