/*
 * Created by Dmitry Scherbakov on 18.02.2020, 3:30
 */

/*
 * Created by Dmitry Scherbakov on 11.02.2020, 16:03
 */

package com.sda.hotel.backend.repository.order;

import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.dao.OrderDao;
import com.sda.hotel.backend.domain.Order;

@Component
public class OrderRepositoryJdbc implements OrderRepository {
    @Autowired
    private OrderDao orderDao;

    @Override
    public boolean checkinGuest(Order order) {
        return orderDao.create(order);
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
