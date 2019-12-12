/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:01
 */

package com.sda.hotel.backend;

import com.sda.hotel.backend.service.*;

import java.util.ArrayList;

public class Application {
    private static Application instance;
    GuestService guestService;
    RoomService roomService;
    ServiceService serviceService;
    public static Application getInstance() {
        if(instance == null){
            instance = new Application();
        }
        return instance;
    }

    private Application(){
        guestService = new GuestServiceImpl();
        roomService = new RoomServiceImpl();
        serviceService = new ServiceServiceImpl();
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

    public ServiceService getServiceService() {
        return serviceService;
    }
}
