/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:51
 */

package com.sda.hotel.backend.repository;

import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.exeption.EntityNotFoundExeption;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GuestRepisitoryImpl implements GuestRepisitory {

    private List<Guest> guests = new ArrayList<>();

    @Override
    public List <Guest> findBySurname(String surname) {
            return guests.stream().filter(g -> surname != null && g.getSurname().toUpperCase()
                    .startsWith(surname.toUpperCase())).collect(Collectors.toList());
    }

    @Override
    public Guest save(Guest guest) {
        guests.add(guest);
        return guest;
    }

    @Override
    public void delete(int id) {
        Guest toDel = guests.stream().filter(g -> g.getId().equals(id)).findFirst()
                .orElseThrow(EntityNotFoundExeption::new);
        guests.remove(id);

    }
}
