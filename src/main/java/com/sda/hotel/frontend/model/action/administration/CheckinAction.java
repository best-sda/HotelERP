/*
 * Created by Dmitry Scherbakov in 02.12.2019, 13:45
 */

package com.sda.hotel.frontend.model.action.administration;

import com.sda.hotel.backend.Application;
import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.domain.Room;
import com.sda.hotel.backend.exeption.EntityNotFoundExeption;
import com.sda.hotel.backend.service.GuestService;
import com.sda.hotel.backend.service.RoomService;
import com.sda.hotel.backend.utils.BeanFactory;
import com.sda.hotel.frontend.model.action.ActionNewThred;
import com.sda.hotel.frontend.view.ViewController;

import java.util.List;
import java.util.Scanner;

public class CheckinAction extends ActionNewThred {
    @Override
    public void execute() {
        ViewController.getInstance().print("Input guest surname to checkin: ");
        Scanner scanner = new Scanner(System.in);
        Application application = (Application) BeanFactory
                .getInstance().getBean("application");
        try {
            String surname = scanner.nextLine();
            GuestService guestService = application.getGuestServiceImpl();
            List<Guest> guests = guestService.findBySurname(surname);
            if (guests.isEmpty()) {
                ViewController.getInstance().print("not found");
            } else {
                guests.forEach(guest -> ViewController.getInstance()
                        .print("ID: " + guest.getId()
                        + " " + guest.getFirstName() + " " + guest.getLastName()));
                ViewController.getInstance().print("Input number to checkin");
                Guest guest = guestService.guestWithId(scanner.nextInt());
                RoomService roomService = application.getRoomServiceImpl();
                List<Room> rooms = roomService.roomList();
                rooms.forEach(room ->
                        ViewController.getInstance().print("Room number: "
                               + room.getId() + " cost:" + room.getCost()));
                if (!rooms.isEmpty()) {
                    ViewController.getInstance()
                            .print("Input number to checkin");
                    Room room = roomService
                            .roomWithId(scanner.nextInt());
                    roomService.setRoomBusy(room);
                    guestService.setRoomToGuest(guest, room.getId());

                } else {
                    ViewController.getInstance().print("not found");
                }

            }

        } catch (EntityNotFoundExeption e) {
            ViewController.getInstance()
                    .print("Guest/room not found" + e.getId());
        }
    }

}
