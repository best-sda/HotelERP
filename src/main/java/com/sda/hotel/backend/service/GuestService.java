/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:31
 */

package com.sda.hotel.backend.service;

import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.domain.Service;

import java.util.List;

@Component
public interface GuestService {
    boolean save(Guest guest);

    List<Guest> findBySurname(String surname);

    void delete(int id);

    Guest guestWithId(int id);

    void setRoomToGuest(Guest guest, Integer roomNumber);

    List<Guest> getChekinedGests();

    void chekout(Integer idGuest);

    void setServiceToGuest(Guest guest, Service service);

    void loadList();

    void saveList();

    List<Guest> getList();
}
