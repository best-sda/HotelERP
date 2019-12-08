/*
 * Created by Dmitry Scherbakov in 08.12.2019, 20:01
 */

package com.sda.hotel.backend;

import com.sda.hotel.backend.service.GuestService;

public class Application {
    private static Application instance;
    GuestService guestService;

    public static Application getInstance() {
        if(instance == null){
            instance = new Application();
        }
        return instance;
    }

    public GuestService getGuestService() {
        return guestService;
    }

    public void setGuestService(GuestService guestService) {
        this.guestService = guestService;
    }
}
