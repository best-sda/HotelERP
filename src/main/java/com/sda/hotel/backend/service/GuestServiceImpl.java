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
    @Autowired(className = "GuestRepositoryImpl")
    private GuestRepisitory guestRepisitoryImpl;

    public void setGuestRepisitoryImpl(GuestRepisitory guestRepisitoryImpl) {
        this.guestRepisitoryImpl = guestRepisitoryImpl;
    }

    @Override
    public Guest save(Guest guest) {
        return guestRepisitoryImpl.save(guest);
    }

    @Override
    public List <Guest> findBySurname(String surname) {
        return guestRepisitoryImpl.findBySurname(surname);
    }

    @Override
    public void delete(int id) {
        guestRepisitoryImpl.delete(id);
    }

    @Override
    public Guest guestWithId(int id) {
        return guestRepisitoryImpl.guestWithId(id);
    }

    @Override
    public void setRoomToGuest(Guest guest, Integer roomNumber) {
        guestRepisitoryImpl.setRoomToGuest(guest, roomNumber);
    }

    @Override
    public List <Guest> getChekinedGests() {
        return guestRepisitoryImpl.getChelinedGests();
    }

    @Override
    public void chekout(Integer idGuest) {
        guestRepisitoryImpl.chekout(idGuest);
    }

    @Override
    public void setServiceToGuest(Guest guest, Service service) {
        guestRepisitoryImpl.setServiceToGuest(guest, service);
    }

    @Override
    public void loadList() {
        guestRepisitoryImpl.loadList();
    }

    @Override
    public void saveList() {
        guestRepisitoryImpl.saveList();
    }

}
