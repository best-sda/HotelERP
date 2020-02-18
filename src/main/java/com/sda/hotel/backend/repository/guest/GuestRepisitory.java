/*
 * Created by Dmitry Scherbakov on 18.02.2020, 3:29
 */

/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:50
 */

package com.sda.hotel.backend.repository.guest;

import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.domain.Service;

import java.util.List;

@Component
public interface GuestRepisitory {
    List<Guest> findBySurname(String surname);

    boolean save(Guest guest);

    void delete(int id);

    Guest findById(int id);

    void setRoomToGuest(Guest guest, Integer roomNumber);

    List<Guest> getChelinedGests();

    void chekout(Integer idGuest);

    void setServiceToGuest(Guest guest, Service service);

    void saveList();

    void loadList();

    List<Guest> getList();
}
