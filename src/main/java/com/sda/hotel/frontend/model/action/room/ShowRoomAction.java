/*
 * Created by Dmitry Scherbakov in 02.12.2019, 13:36
 */

package com.sda.hotel.frontend.model.action.room;

import com.sda.hotel.backend.Application;
import com.sda.hotel.backend.domain.Room;
import com.sda.hotel.backend.service.RoomService;
import com.sda.hotel.backend.utils.BeanFactory;
import com.sda.hotel.frontend.model.action.ActionNewThred;
import com.sda.hotel.frontend.view.ViewController;

import java.util.List;

public class ShowRoomAction extends ActionNewThred {
    @Override
    public void execute() {
        Application application = (Application) BeanFactory
                .getInstance().getBean("application");
        RoomService roomService = application.getRoomServiceImpl();
        List<Room> rooms = roomService.roomList();
        rooms.forEach(room -> ViewController.getInstance()
                .print("Room number: " + room.getId()
                        + " cost:" + room.getCost()));
    }

}
