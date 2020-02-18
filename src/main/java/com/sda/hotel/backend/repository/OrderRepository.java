/*
 * Created by Dmitry Scherbakov on 11.02.2020, 16:02
 */

package com.sda.hotel.backend.repository;

import com.sda.hotel.backend.domain.Order;

public interface OrderRepository {
    boolean checkinGuest(Order order);
}
