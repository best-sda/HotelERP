/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:51
 */

package com.sda.hotel.backend.repository;

import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.domain.Service;
import com.sda.hotel.backend.exeption.EntityNotFoundExeption;
import com.sda.hotel.backend.utils.JsonSerialization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GuestRepisitoryImpl implements GuestRepisitory, Serializable {

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    private List<Guest> guests = new ArrayList<>();

    @Override
    public List<Guest> findBySurname(String surname) {
            return guests.stream().filter(g ->
                    surname != null && g.getSurname().toUpperCase()
                    .startsWith(surname.toUpperCase()))
                    .collect(Collectors.toList());
    }

    @Override
    public Guest save(Guest guest) {
        guests.add(guest);
        return guest;
    }

    @Override
    public void delete(int id) {
        Guest toDel = guests.stream().filter(g ->
                g.getGuestId().equals(id)).findFirst()
                .orElseThrow(EntityNotFoundExeption::new);
        guests.remove(id);

    }

    @Override
    public Guest guestWithId(int id) {
        return guests.stream().filter(guest ->
                guest.getGuestId().equals(id)).findFirst()
                .orElseThrow(EntityNotFoundExeption::new);
    }

    @Override
    public void setRoomToGuest(Guest guest, Integer roomNumber) {
        guest.setRoom(roomNumber);
    }

    @Override
    public List<Guest> getChelinedGests() {
        return guests.stream().filter(guest ->
                guest.getRoom() != null).collect(Collectors.toList());
    }

    @Override
    public void chekout(Integer idGuest) {
        guests.stream().filter(guest ->
                guest.getGuestId().equals(idGuest)).findFirst()
                .ifPresent(guest -> guest.setRoom(null));
    }

    @Override
    public void setServiceToGuest(Guest guest, Service service) {
        guest.addService(service);
    }

    @Override
    public void saveList() {
        JsonSerialization.saveList("guestsList22.txt", getGuests());
    }

    @Override
    public void loadList() {
        JsonSerialization.loadList("guestsList.txt");
    }

}
