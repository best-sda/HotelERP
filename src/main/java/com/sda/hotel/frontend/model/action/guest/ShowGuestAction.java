/*
 * Created by Dmitry Scherbakov in 02.12.2019, 13:43
 */

package com.sda.hotel.frontend.model.action.guest;

import com.sda.hotel.backend.Application;
import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.exeption.EntityNotFoundExeption;
import com.sda.hotel.backend.service.GuestService;
import com.sda.hotel.frontend.model.action.IAction;
import com.sda.hotel.frontend.view.ViewController;

import java.util.List;
import java.util.Scanner;

public class ShowGuestAction implements IAction {

    @Override
    public void execute(Application application) {
        ViewController.getInstance().print("Input guest surname to delete: ");
        Scanner scanner = new Scanner(System.in);

        try {
            String surname = scanner.nextLine();

            GuestService guestService = application.getGuestServiceImpl();
            List <Guest> guests = guestService.findBySurname(surname);
            if (guests.isEmpty()) {
                ViewController.getInstance().print("not found");
            } else {
                guests.forEach(guest -> ViewController.getInstance().print("ID: " + guest.getGuestId()
                        + " " + guest.getName() + " " + guest.getSurname()));
            }
        } catch (EntityNotFoundExeption e) {
            ViewController.getInstance().print("Guest not found" + e.getId());
        }

    }
}
