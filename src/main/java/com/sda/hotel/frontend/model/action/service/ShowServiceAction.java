/*
 * Created by Dmitry Scherbakov in 02.12.2019, 13:52
 */

package com.sda.hotel.frontend.model.action.service;

import com.sda.hotel.backend.Application;
import com.sda.hotel.backend.domain.Service;
import com.sda.hotel.backend.exeption.EntityNotFoundExeption;
import com.sda.hotel.backend.service.ServiceService;
import com.sda.hotel.frontend.model.action.IAction;
import com.sda.hotel.frontend.view.ViewController;

import java.util.List;
import java.util.Scanner;

public class ShowServiceAction implements IAction {
    @Override
    public void execute() {
        ViewController.getInstance().print("Input service name to delete: ");
        Scanner scanner = new Scanner(System.in);

        try {
            String name = scanner.nextLine();

            ServiceService serviceService = Application.getInstance().getServiceService();
            List <Service> services = serviceService.findByName(name);
            if (services.isEmpty()){
                ViewController.getInstance().print("not found");
            }else {
                services.forEach(service -> ViewController.getInstance().print("ID: " + service.getId()
                        + " " + service.getServiceName() + " " + service.getDescription()));
            }

        } catch (EntityNotFoundExeption e) {
            ViewController.getInstance().print("Service not found" + e.getId());
        }
    }
}
