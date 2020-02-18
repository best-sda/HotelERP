/*
 * Created by Dmitry Scherbakov on 18.02.2020, 3:29
 */

/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:51
 */

package com.sda.hotel.backend.repository.guest;

import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.domain.Service;

import java.io.Serializable;
import java.util.List;

@Component
public class GuestRepisitoryImpl implements GuestRepisitory, Serializable {


    @Override
    public List<Guest> findBySurname(String surname) {
        return null;
    }

    @Override
    public boolean save(Guest guest) {
        return false;
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
        return null;
    }
}
