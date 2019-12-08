/*
 * Created by Dmitry Scherbakov in 25.11.2019, 15:29
 */

package com.sda.hotel.frontend.model.navigator;

import com.sda.hotel.frontend.exeption.MenuExeption;
import com.sda.hotel.frontend.model.action.IAction;
import com.sda.hotel.frontend.model.menu.Menu;
import com.sda.hotel.frontend.model.menu.MenuItem;
import com.sda.hotel.frontend.view.ViewController;

import java.util.Optional;
import java.util.stream.Collectors;

public class Navigator implements Inavigator {
    private Menu curentMenu;

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
        ViewController.getInstance().print(curentMenu.getName() + "Please, choose->");
        ViewController.getInstance().printList(curentMenu.getItems().stream().map(MenuItem::getTitle).collect(Collectors.toList()));
    }

    @Override
    public void navigate(Integer index) throws MenuExeption {
        if (index < 0 || index > curentMenu.getItems().size()){
            throw  new MenuExeption("invalide index");
        }
        MenuItem submenu = curentMenu.getItems().get(index);
        Optional.ofNullable(submenu.getAction()).ifPresent(IAction::execute);
        curentMenu = submenu.getNextMenu();
    }
}
