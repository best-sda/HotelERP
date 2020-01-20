/*
 * Created by Dmitry Scherbakov in 02.12.2019, 13:35
 */

package com.sda.hotel.frontend.model.action.room;

import com.sda.hotel.backend.Application;
import com.sda.hotel.backend.exeption.EntityNotFoundExeption;
import com.sda.hotel.backend.service.RoomService;
import com.sda.hotel.backend.utils.BeanFactory;
import com.sda.hotel.frontend.model.action.ActionNewThred;
import com.sda.hotel.frontend.model.action.IAction;
import com.sda.hotel.frontend.view.ViewController;

import java.util.Scanner;

public class DelRoomAction extends ActionNewThred {

    @Override
    public void execute() {
        Application application = (Application) BeanFactory.getInstance().getBean("application");
        RoomService roomService = application.getRoomServiceImpl();
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
