/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:50
 */

package com.sda.hotel.backend.repository;

import com.sda.hotel.backend.domain.Guest;

import java.util.List;

public interface GuestRepisitory {
    List <Guest> findBySurname(String surname);
    Guest save(Guest guest);
    void delete(int id);
}
