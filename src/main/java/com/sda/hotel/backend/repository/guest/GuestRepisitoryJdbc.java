/*
 * Created by Dmitry Scherbakov on 18.02.2020, 3:29
 */

/*
 * Created by Dmitry Scherbakov on 10.02.2020, 22:16
 */

package com.sda.hotel.backend.repository.guest;

import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.dao.GuestDao;
import com.sda.hotel.backend.dao.OrderDao;
import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.domain.Order;
import com.sda.hotel.backend.domain.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Guest> guests = guestDao.getAll();
        return guests.stream().filter(g -> g.getLastName().equals(surname))
                .collect(Collectors.toList());
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
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
        for (Guest guest : guests) {
            for (Order order : orders) {
                if (guest.getId() == order.getGuestId()) {
                    result.add(guest);
                }
            }
        }
        return result;
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
