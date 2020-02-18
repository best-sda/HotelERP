/*
 * Created by Dmitry Scherbakov on 17.02.2020, 22:15
 */

package com.sda.hotel.backend.service;

import com.sda.hotel.backend.domain.Order;

public interface OrderService {
    boolean chekinGuest(Order order);
}
