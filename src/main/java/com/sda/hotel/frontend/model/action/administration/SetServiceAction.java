/*
 * Created by Dmitry Scherbakov in 02.12.2019, 13:45
 */

package com.sda.hotel.frontend.model.action.administration;

import com.sda.hotel.backend.Application;
import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.domain.Service;
import com.sda.hotel.backend.exeption.EntityNotFoundExeption;
import com.sda.hotel.backend.service.GuestService;
import com.sda.hotel.backend.service.ServiceService;
import com.sda.hotel.frontend.model.action.IAction;
import com.sda.hotel.frontend.view.ViewController;

import java.util.List;
import java.util.Scanner;

public class SetServiceAction implements IAction {
    @Override
    public void execute() {
        ViewController.getInstance().print("Input guest surname to choose: ");
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
                Guest guest = guestService.guestWithId(scanner.nextInt());


                ViewController.getInstance().print("Input service name to choose: ");
                String name = scanner.nextLine();
                ServiceService serviceService = Application.getInstance().getServiceService();
                List <Service> services = serviceService.findByName(name);
                if (services.isEmpty()){
                    ViewController.getInstance().print("not found");
                }else {
                    services.forEach(service -> ViewController.getInstance().print("ID: " + service.getId()
                            + " " + service.getServiceName() + " " + service.getDescription()));
                    ViewController.getInstance().print("Input number to delete");
                    Service service = serviceService.servicewithId(scanner.nextInt());
                    guestService.setServiceToGuest(guest, service);
                }
            }

        } catch (EntityNotFoundExeption e) {
            ViewController.getInstance().print("Room not found" + e.getId());
        }
    }

}
