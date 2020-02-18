/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:01
 */

package com.sda.hotel.backend;

import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.repository.OrderRepository;
import com.sda.hotel.backend.service.GuestService;
import com.sda.hotel.backend.service.OrderService;
import com.sda.hotel.backend.service.RoomService;
import com.sda.hotel.backend.service.ServiceService;

@Component
public class Application {
    @Autowired
    private  GuestService guestServiceImpl;
    @Autowired
    private RoomService roomServiceImpl;
    @Autowired
    private ServiceService serviceServiceImpl;
    @Autowired
    private OrderService orderServiceImpl;

    public OrderService getOrderServiceImpl() {
        return orderServiceImpl;
    }

    public void setOrderServiceImpl(OrderService orderServiceImpl) {
        this.orderServiceImpl = orderServiceImpl;
    }

    public void setRoomServiceImpl(final RoomService roomServiceImpl) {
        this.roomServiceImpl = roomServiceImpl;
    }

    public void setServiceServiceImpl(final ServiceService serviceServiceImpl) {
        this.serviceServiceImpl = serviceServiceImpl;
    }

    public GuestService getGuestServiceImpl() {
        return guestServiceImpl;
    }

    public void setGuestServiceImpl(final GuestService guestServiceImpl) {
        this.guestServiceImpl = guestServiceImpl;
    }

    public RoomService getRoomServiceImpl() {
        return roomServiceImpl;
    }

    public ServiceService getServiceServiceImpl() {
        return serviceServiceImpl;
    }

}
