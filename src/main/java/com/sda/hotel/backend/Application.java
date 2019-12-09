/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:01
 */

package com.sda.hotel.backend;

import com.sda.hotel.backend.service.GuestService;
import com.sda.hotel.backend.service.GuestServiceImpl;
import com.sda.hotel.backend.service.RoomService;
import com.sda.hotel.backend.service.RoomServiceImpl;

import java.util.ArrayList;

public class Application {
    private static Application instance;
    GuestService guestService;
    RoomService roomService;

    public static Application getInstance() {
        if(instance == null){
            instance = new Application();
        }
        return instance;
    }

    private Application(){
        guestService = new GuestServiceImpl();
        roomService = new RoomServiceImpl();
    }

    public GuestService getGuestService() {
        return guestService;
    }

    public void setGuestService(GuestService guestService) {
        this.guestService = guestService;
    }

    public RoomService getRoomService() {
        return roomService;
    }
}
