/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:36
 */

package com.sda.hotel.backend.service;

import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.domain.Service;
import com.sda.hotel.backend.repository.GuestRepisitory;
import com.sda.hotel.backend.repository.GuestRepisitoryImpl;

import java.util.List;

public class GuestServiceImpl implements GuestService {

    private GuestRepisitory guestRepisitory = new GuestRepisitoryImpl();

    @Override
    public Guest save(Guest guest) {
      return guestRepisitory.save(guest);
    }

    @Override
    public List <Guest> findBySurname(String surname) {
        return guestRepisitory.findBySurname(surname);
    }

    @Override
    public void delete(int id) {
        guestRepisitory.delete(id);
    }

    @Override
    public Guest guestWithId(int id) {
        return guestRepisitory.guestWithId(id);
    }

    @Override
    public void setRoomToGuest(Guest guest, Integer roomNumber) {
        guestRepisitory.setRoomToGuest(guest, roomNumber);
    }

    @Override
    public List <Guest> getChekinedGests() {
        return guestRepisitory.getChelinedGests();
    }

    @Override
    public void chekout(Integer idGuest) {
        guestRepisitory.chekout(idGuest);
    }

    @Override
    public void setServiceToGuest(Guest guest, Service service) {
        guestRepisitory.setServiceToGuest(guest, service);
    }

    @Override
    public void loadList() {
        guestRepisitory.loadList();
    }

    @Override
    public void saveList() {
        guestRepisitory.saveList();
    }

}
