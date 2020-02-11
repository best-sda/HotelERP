/*
 * Created by Dmitry Scherbakov on 10.02.2020, 22:16
 */

package com.sda.hotel.backend.repository;

import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.dao.GuestDao;
import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.domain.Service;

import java.util.List;
@Component
public class GuestRepisitoryJdbc implements GuestRepisitory {
    public void setGuestDao(GuestDao guestDao) {
        this.guestDao = guestDao;
    }

    @Autowired
    GuestDao guestDao;
    @Override
    public List<Guest> findBySurname(String surname) {
        return null;
    }

    @Override
    public boolean save(Guest guest) {
        return guestDao.create(guest);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Guest findById(int id) {
        return null;
    }

    @Override
    public void setRoomToGuest(Guest guest, Integer roomNumber) {

    }

    @Override
    public List<Guest> getChelinedGests() {
        return null;
    }

    @Override
    public void chekout(Integer idGuest) {

    }

    @Override
    public void setServiceToGuest(Guest guest, Service service) {

    }

    @Override
    public void saveList() {

    }

    @Override
    public void loadList() {

    }

    @Override
    public List<Guest> getList() {
        return guestDao.getAll();
    }
}
