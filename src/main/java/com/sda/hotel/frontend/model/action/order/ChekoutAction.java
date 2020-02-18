/*
 * Created by Dmitry Scherbakov in 02.12.2019, 13:45
 */

package com.sda.hotel.frontend.model.action.order;

import com.sda.hotel.backend.Application;
import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.exeption.EntityNotFoundExeption;
import com.sda.hotel.backend.service.GuestService;
import com.sda.hotel.backend.service.RoomService;
import com.sda.hotel.backend.utils.BeanFactory;
import com.sda.hotel.frontend.model.action.ActionNewThred;
import com.sda.hotel.frontend.view.ViewController;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class ChekoutAction extends ActionNewThred {
    private Logger logger = Logger.getLogger(CheckinAction.class);
    @Override
    public void execute() {
        Application application = (Application) BeanFactory.getInstance()
                .getBean("application");
        try {
            GuestService guestService = application.getGuestServiceImpl();
            RoomService roomService = application.getRoomServiceImpl();
            List<Guest> guests = guestService.getChekinedGests();
            guests.forEach(guest -> ViewController.getInstance()
                    .print(guest.getId() + " " + guest.getFirstName() + " "
                    +  guest.getLastName()));
            Scanner scanner = new Scanner(System.in);
            ViewController.getInstance().print("Chose id guest to checkout: ");
            int guestId = scanner.nextInt();
            guestService.chekout(guestId);
        } catch (EntityNotFoundExeption e) {
            logger.error("Nothing chekined guests" + e);
            ViewController.getInstance().print("Nothing chekined guests");
        }

    }
}
