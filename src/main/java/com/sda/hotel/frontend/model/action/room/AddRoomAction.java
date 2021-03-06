/*
 * Created by Dmitry Scherbakov in 02.12.2019, 13:34
 */

package com.sda.hotel.frontend.model.action.room;

import com.sda.hotel.backend.Application;
import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.domain.Room;
import com.sda.hotel.backend.utils.BeanFactory;
import com.sda.hotel.frontend.model.action.ActionNewThred;
import com.sda.hotel.frontend.view.ViewController;

import java.util.Scanner;

@Component
public class AddRoomAction extends ActionNewThred {
    @Override
    public void execute() {
        Application application = (Application) BeanFactory
                .getInstance().getBean("application");
        ViewController.getInstance().print("Input room info: ");
        Scanner scanner = new Scanner(System.in);
        ViewController.getInstance().print("Input room number: ");
        Integer number = scanner.nextInt();
        ViewController.getInstance().print("Input room status: ");
        String status = scanner.nextLine();
        ViewController.getInstance().print("Input room id");
        int id = scanner.nextInt();
        ViewController.getInstance().print("Input room cost");
        int cost = scanner.nextInt();
        Room room = application.getRoomServiceImpl()
                .save(new Room(id, number, status, false, cost ));
        ViewController.getInstance()
                .print("Room created with id: " + room.getId());
    }
}
