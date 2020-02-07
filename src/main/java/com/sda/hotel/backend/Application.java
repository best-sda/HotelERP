/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:01
 */

package com.sda.hotel.backend;

import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.service.GuestService;
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
