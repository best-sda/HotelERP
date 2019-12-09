/*
 * Created by Dmitry Scherbakov in 09.12.2019, 15:22
 */

package com.sda.hotel.backend.service;

import com.sda.hotel.backend.domain.Room;

import java.util.List;

public interface RoomService {
    Room save(Room room);

    List <Room> roomList(Integer number);

    void delete(int id);
}
