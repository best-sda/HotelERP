/*
 * Created by Dmitry Scherbakov on 11.02.2020, 16:02
 */

package com.sda.hotel.backend.repository;

import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.dao.OrderDao;
import com.sda.hotel.backend.domain.Order;

public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public boolean checkinGuest(Order order) {
        throw new UnsupportedOperationException();
    }
}
