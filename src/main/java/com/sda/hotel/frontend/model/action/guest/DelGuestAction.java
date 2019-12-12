/*
 * Created by Dmitry Scherbakov in 02.12.2019, 13:42
 */

package com.sda.hotel.frontend.model.action.guest;

import com.sda.hotel.backend.Application;
import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.exeption.EntityNotFoundExeption;
import com.sda.hotel.backend.repository.GuestRepisitory;
import com.sda.hotel.backend.service.GuestService;
import com.sda.hotel.frontend.model.action.IAction;
import com.sda.hotel.frontend.view.ViewController;

import java.awt.print.Book;
import java.util.List;
import java.util.Scanner;

public class DelGuestAction implements IAction {

    @Override
    public void execute() {
        ViewController.getInstance().print("Input guest surname to delete: ");
        Scanner scanner = new Scanner(System.in);

       try {
           String surname = scanner.nextLine();

           GuestService guestService = Application.getInstance().getGuestService();
           List <Guest> guests = guestService.findBySurname(surname);
           if (guests.isEmpty()){
                ViewController.getInstance().print("not found");
           }else {
               guests.forEach(guest -> ViewController.getInstance().print("ID: " + guest.getId()
                       + " " + guest.getName() + " " + guest.getSurname()));
               ViewController.getInstance().print("Input number to delete");
               guestService.delete(scanner.nextInt());
           }

       } catch (EntityNotFoundExeption e) {
           ViewController.getInstance().print("Room not found" + e.getId());
       }
    }
}
