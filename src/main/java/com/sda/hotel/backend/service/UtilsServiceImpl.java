/*
 * Created by Dmitry Scherbakov in 15.12.2019, 21:23
 */

package com.sda.hotel.backend.service;

import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.annotation.Component;

@Component
public class UtilsServiceImpl implements UtilsService {
    @Autowired
    private ServiceService serviceServiceImpl;
    @Autowired
    private GuestService guestServiceImpl;
    @Autowired
    private RoomService roomServiceImpl;

    public void setServiceServiceImpl(ServiceService serviceServiceImpl) {
        this.serviceServiceImpl = serviceServiceImpl;
    }

    public void setGuestServiceImpl(GuestService guestServiceImpl) {
        this.guestServiceImpl = guestServiceImpl;
    }

    public void setRoomServiceImpl(RoomService roomServiceImpl) {
        this.roomServiceImpl = roomServiceImpl;
    }

    @Override
    public void saveBase() {
        roomServiceImpl.saveList();
        guestServiceImpl.saveList();
        serviceServiceImpl.saveList();
    }

    @Override
    public void loadFile() {
        roomServiceImpl.loadList();
        guestServiceImpl.loadList();
        serviceServiceImpl.loadList();
    }
}
