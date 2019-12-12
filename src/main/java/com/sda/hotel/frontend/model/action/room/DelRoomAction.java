/*
 * Created by Dmitry Scherbakov in 02.12.2019, 13:35
 */

package com.sda.hotel.frontend.model.action.room;

import com.sda.hotel.backend.Application;
import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.exeption.EntityNotFoundExeption;
import com.sda.hotel.backend.service.GuestService;
import com.sda.hotel.backend.service.RoomService;
import com.sda.hotel.frontend.model.action.IAction;
import com.sda.hotel.frontend.view.ViewController;

import java.util.List;
import java.util.Scanner;

public class DelRoomAction implements IAction {
    @Override
    public void execute() {
        RoomService roomService = Application.getInstance().getRoomService();
        ViewController.getInstance().print("Input room number to delete: ");
        Scanner scanner = new Scanner(System.in);
        Integer roomNumber = scanner.nextInt();
       try{
           roomService.delete(roomNumber);
       } catch (EntityNotFoundExeption e) {
           ViewController.getInstance().print("Room not found" + e.getId());
       }

    }
}
