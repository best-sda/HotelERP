/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:36
 */

package com.sda.hotel.backend.service;

import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.domain.Service;
import com.sda.hotel.backend.repository.GuestRepisitory;

import java.util.List;

@Component
public class GuestServiceImpl implements GuestService {
    @Autowired
    private GuestRepisitory guestRepisitoryJdbc;

    
    public GuestRepisitory getGuestRepisitoryJdbc() {
        return guestRepisitoryJdbc;
    }

    public void setGuestRepisitoryJdbc(GuestRepisitory guestRepisitoryJdbc) {
        this.guestRepisitoryJdbc = guestRepisitoryJdbc;
    }

    @Override
    public boolean save(Guest guest) {
        return guestRepisitoryJdbc.save(guest);
    }

    @Override
    public List<Guest> findBySurname(String surname) {
        return guestRepisitoryJdbc.findBySurname(surname);
    }

    @Override
    public void delete(int id) {
        guestRepisitoryJdbc.delete(id);
    }

    @Override
    public Guest guestWithId(int id) {
        return guestRepisitoryJdbc.findById(id);
    }

    @Override
    public void setRoomToGuest(Guest guest, Integer roomNumber) {
        guestRepisitoryJdbc.setRoomToGuest(guest, roomNumber);
    }

    @Override
    public List<Guest> getChekinedGests() {
        return guestRepisitoryJdbc.getChelinedGests();
    }

    @Override
    public void chekout(Integer idGuest) {
        guestRepisitoryJdbc.chekout(idGuest);
    }

    @Override
    public void setServiceToGuest(Guest guest, Service service) {
        guestRepisitoryJdbc.setServiceToGuest(guest, service);
    }

    @Override
    public void loadList() {
        guestRepisitoryJdbc.loadList();
    }

    @Override
    public void saveList() {
        guestRepisitoryJdbc.saveList();
    }

    @Override
    public List<Guest> getList() {
        return guestRepisitoryJdbc.getList();
    }

}
