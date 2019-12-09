/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:31
 */

package com.sda.hotel.backend.service;

import com.sda.hotel.backend.domain.Guest;

import java.util.List;

public interface GuestService {
    Guest save(Guest guest);
    List<Guest> findBySurname(String surname);
    void delete(int id);
}
