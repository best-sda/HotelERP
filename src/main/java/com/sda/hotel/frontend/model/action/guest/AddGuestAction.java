/*
 * Created by Dmitry Scherbakov in 02.12.2019, 13:41
 */

package com.sda.hotel.frontend.model.action.guest;

import com.sda.hotel.backend.Application;
import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.domain.Guest;
import com.sda.hotel.backend.service.GuestService;
import com.sda.hotel.backend.utils.BeanFactory;
import com.sda.hotel.frontend.model.action.ActionNewThred;
import com.sda.hotel.frontend.view.ViewController;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

@Component
public class AddGuestAction extends ActionNewThred {
    Logger logger = LogManager.getLogger(AddGuestAction.class);

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        Application application = (Application)
                BeanFactory.getInstance().getBean("application");
        ViewController.getInstance().print("Input guest info: ");
        ViewController.getInstance().print("Input guest first name: ");
        String name = scanner.nextLine();
        ViewController.getInstance().print("Input guest last name: ");
        String surname = scanner.nextLine();
        ViewController.getInstance().print("Input guest id card");
        int idCard = scanner.nextInt();
        ViewController.getInstance().print("Input guest phone");
        String phone = scanner.nextLine();
        GuestService guestService = application.getGuestServiceImpl();
        boolean guest = guestService.save(new Guest(name, surname, idCard, phone));
        ViewController.getInstance().print("Guest created: " + guest);

    }

}
