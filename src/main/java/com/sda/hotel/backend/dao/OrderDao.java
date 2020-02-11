/*
 * Created by Dmitry Scherbakov on 11.02.2020, 1:25
 */

package com.sda.hotel.backend.dao;

import com.sda.hotel.backend.domain.Order;

import java.util.List;

public class OrderDao extends AbstractDaoImpl<Order, Integer> {
    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public Order getEntityById(Integer id) {
        return null;
    }

    @Override
    public Order update(Order entity) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(Order entity) {
        return false;
    }
}
