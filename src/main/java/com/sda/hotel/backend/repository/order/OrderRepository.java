/*
 * Created by Dmitry Scherbakov on 18.02.2020, 3:30
 */

/*
 * Created by Dmitry Scherbakov on 11.02.2020, 16:02
 */

package com.sda.hotel.backend.repository.order;

import com.sda.hotel.backend.domain.Order;

public interface OrderRepository {
    boolean checkinGuest(Order order);
}
