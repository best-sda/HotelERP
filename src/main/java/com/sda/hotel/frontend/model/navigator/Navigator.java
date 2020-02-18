/*
 * Created by Dmitry Scherbakov in 25.11.2019, 15:29
 */

package com.sda.hotel.frontend.model.navigator;

import com.sda.hotel.backend.Application;
import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.frontend.exeption.MenuExeption;
import com.sda.hotel.frontend.model.action.IAction;
import com.sda.hotel.frontend.model.menu.Menu;
import com.sda.hotel.frontend.model.menu.MenuItem;
import com.sda.hotel.frontend.view.ViewController;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class Navigator implements Inavigator {
    private Menu curentMenu;

    @Autowired
    private Application application;

    private IAction action;

    public void setApplication(Application application) {
        this.application = application;
    }

    @Override
    public Menu getCurentMenu() {
        return curentMenu;
    }

    @Override
    public void setCurentMenu(Menu curentMenu) {
        this.curentMenu = curentMenu;
    }

    @Override
    public void printMenu() {
        ViewController.getInstance().print(curentMenu.getName()
                + "Please, choose->");
        ViewController.getInstance().printList(curentMenu.getItems()
                .stream().map(MenuItem::getTitle)
                .collect(Collectors.toList()));
    }

    @Override
    public void navigate(Integer index) throws MenuExeption {
        if (index < 0 || index > curentMenu.getItems().size()) {
            throw new MenuExeption("invalide index");
        }
        MenuItem submenu = curentMenu.getItems().get(index);
        if (Optional.ofNullable(submenu.getAction()).isPresent()) {
            try {
                action = submenu.getAction();
                Thread thread = new Thread((Runnable) action);
                thread.start();
                // if (thread.isInterrupted()) {
                thread.join();
                //  }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        curentMenu = submenu.getNextMenu();
    }
}
