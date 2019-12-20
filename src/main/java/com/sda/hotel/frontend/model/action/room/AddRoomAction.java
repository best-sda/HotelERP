/*
 * Created by Dmitry Scherbakov in 02.12.2019, 13:34
 */

package com.sda.hotel.frontend.model.action.room;

import com.sda.hotel.backend.Application;
import com.sda.hotel.backend.domain.Room;
import com.sda.hotel.backend.service.RoomService;
import com.sda.hotel.frontend.model.action.IAction;
import com.sda.hotel.frontend.view.ViewController;

import java.util.Scanner;

public class AddRoomAction implements IAction {
    @Override
    public void execute() {
        ViewController.getInstance().print("Input room info: ");
        Scanner scanner = new Scanner(System.in);
        ViewController.getInstance().print("Input room number: ");
        Integer number = scanner.nextInt();
        ViewController.getInstance().print("Input room status: ");
        String status = scanner.nextLine();
        ViewController.getInstance().print("Input room description");
        Integer id = scanner.nextInt();

        RoomService roomService = Application.getInstance().getRoomService();
        Room room = roomService.save(new Room(number,status, id));
        ViewController.getInstance().print("Room created with id: " + room.getNumber());
    }
}
