/*
 * Created by Dmitry Scherbakov in 15.12.2019, 21:23
 */

package com.sda.hotel.backend.service;

import com.sda.hotel.backend.Application;
import com.sda.hotel.backend.repository.*;

public class UtilsServiceImpl implements UtilsService {
    private ServiceService serviceService = Application.getInstance().getServiceService();
    private GuestService guestService = Application.getInstance().getGuestService();
    private RoomService roomService = Application.getInstance().getRoomService();

    @Override
    public void saveBase() {
        roomService.saveList();
        guestService.saveList();
        serviceService.saveList();
    }

    @Override
    public void loadFile() {
        roomService.loadList();
        guestService.loadList();
        serviceService.loadList();
    }
}
