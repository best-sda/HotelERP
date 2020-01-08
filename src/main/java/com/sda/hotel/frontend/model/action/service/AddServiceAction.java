/*
 * Created by Dmitry Scherbakov in 02.12.2019, 13:52
 */

package com.sda.hotel.frontend.model.action.service;

import com.sda.hotel.backend.Application;
import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.backend.domain.Service;
import com.sda.hotel.backend.service.ServiceService;
import com.sda.hotel.frontend.model.action.IAction;
import com.sda.hotel.frontend.view.ViewController;

import java.util.Scanner;

@Component
public class AddServiceAction implements IAction {

    @Override
    public void execute(Application application) {
        ViewController.getInstance().print("Input service info: ");
        Scanner scanner = new Scanner(System.in);
        ViewController.getInstance().print("Input service name: ");
        String name = scanner.nextLine();
        ViewController.getInstance().print("Input service cost: ");
        Integer cost = scanner.nextInt();
        ViewController.getInstance().print("Input service description");
        String description = scanner.nextLine();

        ServiceService serviceService = application.getServiceServiceImpl();
        Service service = serviceService.save(new Service(name, cost, description));
        ViewController.getInstance().print("Service created with id: " + service.getServiceId());
    }

}
