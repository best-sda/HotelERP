/*
 * Created by Dmitry Scherbakov in 02.12.2019, 13:41
 */

package com.sda.hotel.frontend.model.action.guest;

import com.sda.hotel.backend.Application;
import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.service.GuestService;
import com.sda.hotel.backend.utils.BeanFactory;
import com.sda.hotel.frontend.model.action.ActionNewThred;
import com.sda.hotel.frontend.model.action.IAction;
import com.sda.hotel.frontend.view.ViewController;

import java.util.Scanner;

@Component
public class AddGuestAction extends ActionNewThred {

    @Override
    public void execute() {
        Application application = (Application) BeanFactory.getInstance().getBean("application");
        ViewController.getInstance().print("Input guest info: ");
        Scanner scanner = new Scanner(System.in);
        ViewController.getInstance().print("Input guest name: ");
        String name = scanner.nextLine();
        ViewController.getInstance().print("Input guest surname: ");
        String surname = scanner.nextLine();
        ViewController.getInstance().print("Input guest id card");
        Integer id = scanner.nextInt();
        GuestService guestService = application.getGuestServiceImpl();
        Guest guest = guestService.save(new Guest(name, surname, id));
        ViewController.getInstance().print("Guest created with id: " + guest.getGuestId());
    }
}
