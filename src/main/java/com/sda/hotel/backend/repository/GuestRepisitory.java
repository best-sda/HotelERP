/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:50
 */

package com.sda.hotel.backend.repository;

import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.domain.Service;

import java.util.List;

@Component
public interface GuestRepisitory {
    List <Guest> findBySurname(String surname);

    Guest save(Guest guest);

    void delete(int id);

    Guest guestWithId(int id);

    void setRoomToGuest(Guest guest, Integer roomNumber);

    List <Guest> getChelinedGests();

    void chekout(Integer idGuest);

    void setServiceToGuest(Guest guest, Service service);

    void saveList();

    void loadList();
}
