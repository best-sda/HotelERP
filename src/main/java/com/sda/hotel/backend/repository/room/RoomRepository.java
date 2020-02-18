/*
 * Created by Dmitry Scherbakov on 18.02.2020, 3:31
 */

/*
 * Created by Dmitry Scherbakov in 09.12.2019, 15:25
 */

package com.sda.hotel.backend.repository.room;

import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.domain.Room;

import java.util.List;

@Component
public interface RoomRepository {
    Room save(Room guest);

    void delete(int id);

    List<Room> roomList();

    Room roomWithId(Integer id);

    void setRoomBusy(Room room);

    void saveList();

    void loadList();
}
