/*
 * Created by Dmitry Scherbakov on 10.02.2020, 22:16
 */

package com.sda.hotel.backend.repository;

import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.dao.GuestDao;
import com.sda.hotel.backend.dao.OrderDao;
import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.domain.Order;
import com.sda.hotel.backend.domain.Service;

import java.util.ArrayList;
import java.util.List;
@Component
public class GuestRepisitoryJdbc implements GuestRepisitory {
    public void setGuestDao(GuestDao guestDao) {
        this.guestDao = guestDao;
    }

    @Autowired
    GuestDao guestDao;
    @Autowired
    OrderDao orderDao;
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
        guestDao.delete(id);
    }

    @Override
    public Guest findById(int id) {
        return guestDao.getEntityById(id);
    }

    @Override
    public void setRoomToGuest(Guest guest, Integer roomNumber) {
    }

    @Override
    public List<Guest> getChelinedGests() {
        List<Guest> guests = guestDao.getAll();
        List<Order> orders = orderDao.getAll();
        List<Guest> result = new ArrayList<>();
        for(Guest guest : guests){
            for (Order order : orders){
                if(guest.getId() == order.getGuestId()){
                    guests.add(guest);
                }
            }
        }
        return guests;
    }

    @Override
    public void chekout(Integer idGuest) {
        List<Order> orders = orderDao.getAll();
        orderDao.delete(orders.stream()
                .filter(order -> order.getGuestId() == idGuest).findFirst().orElse(null).getId());
    }

    @Override
    public void setServiceToGuest(Guest guest, Service service) {

    }

    @Override
    public void saveList() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadList() {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Guest> getList() {
        return guestDao.getAll();
    }
}
