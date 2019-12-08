/*
 * Created by Dmitry Scherbakov in 02.12.2019, 13:41
 */

package com.sda.hotel.frontend.model.action.guest;

import com.sda.hotel.backend.Application;
import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.service.GuestService;
import com.sda.hotel.frontend.model.action.IAction;
import com.sda.hotel.frontend.view.ViewController;

import java.util.Scanner;

public class AddGuestAction implements IAction {
    @Override
    public void execute() {
        ViewController.getInstance().print("Input guest info: ");
        Scanner scanner = new Scanner(System.in);
        ViewController.getInstance().print("Input guest name: ");
        String name = scanner.nextLine();
        ViewController.getInstance().print("Input guest surname: ");
        String surname = scanner.nextLine();
        ViewController.getInstance().print("Input guest id card");
        Integer id = scanner.nextInt();

        GuestService guestService = Application.getInstance().getGuestService();
        Guest guest = guestService.save(new Guest(name, surname, id));
        ViewController.getInstance().print("Guest created with id: " + guest.getId());
    }
}
