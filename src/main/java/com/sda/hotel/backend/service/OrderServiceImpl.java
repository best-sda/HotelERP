/*
 * Created by Dmitry Scherbakov on 17.02.2020, 22:15
 */

package com.sda.hotel.backend.service;

import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.domain.Order;
import com.sda.hotel.backend.repository.OrderRepository;
import com.sda.hotel.backend.repository.RoomRepository;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepositoryJdbc;
    @Override
    public boolean chekinGuest(Order order) {
        return orderRepositoryJdbc.checkinGuest(order);
    }

    public void setOrderRepositoryJdbc(OrderRepository orderRepositoryJdbc) {
        this.orderRepositoryJdbc = orderRepositoryJdbc;
    }
}
