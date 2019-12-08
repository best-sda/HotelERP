/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:36
 */

package com.sda.hotel.backend.service;

import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.repository.GuestRepisitory;

import java.util.List;

public class GuestServiceImpl implements GuestService {

    private GuestRepisitory guestRepisitory;

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
}
