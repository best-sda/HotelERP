/*
 * Created by Dmitry Scherbakov in 02.12.2019, 13:43
 */

package com.sda.hotel.frontend.model.action.guest;

import com.sda.hotel.backend.Application;
import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.exeption.EntityNotFoundExeption;
import com.sda.hotel.backend.service.GuestService;
import com.sda.hotel.backend.utils.BeanFactory;
import com.sda.hotel.frontend.model.action.ActionNewThred;
import com.sda.hotel.frontend.view.ViewController;

import java.util.List;
import java.util.Scanner;

public class ShowGuestAction extends ActionNewThred {

    @Override
    public void execute() {
        Application application = (Application) BeanFactory
                .getInstance().getBean("application");
        ViewController.getInstance()
                .print("Guests: ");
        Scanner scanner = new Scanner(System.in);

        try {
            GuestService guestService = application
                    .getGuestServiceImpl();
            List<Guest> guests = guestService.getList();
            if (guests.isEmpty()) {
                ViewController.getInstance().print("not found");
            } else {
                guests.forEach(guest -> ViewController
                        .getInstance().print("ID: " + guest.getId()
                        + " " + guest.getFirstName() + " " + guest.getLastName()));
            }
        } catch (EntityNotFoundExeption e) {
            ViewController.getInstance().print("Guest not found" + e.getId());
        }

    }
}
