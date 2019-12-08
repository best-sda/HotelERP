/*
 * Created by Dmitry Scherbakov in 25.11.2019, 15:32
 */

package com.sda.hotel.frontend.controller;

import com.sda.hotel.frontend.exeption.MenuExeption;
import com.sda.hotel.frontend.model.builder.IBuilder;
import com.sda.hotel.frontend.model.menu.MenuItem;
import com.sda.hotel.frontend.model.navigator.Inavigator;
import com.sda.hotel.frontend.view.ViewController;

import java.util.Optional;
import java.util.Scanner;

public class MenuController {
    private IBuilder builder;
    private Inavigator navigator;

    public MenuController(IBuilder builder, Inavigator navigator) {
        this.builder = builder;
        this.navigator = navigator;
    }

    public void run() {
        navigator.setCurentMenu(builder.buildMenu());
        ViewController.getInstance().print("Hotel program");

        while (true){
            navigator.printMenu();

            Scanner scanner = new Scanner(System.in);

            Integer index = scanner.nextInt();

            try {
                navigator.navigate(index - 1);
            } catch ( MenuExeption e) {
                ViewController.getInstance().print("invalid number, shod be in range " + 1
                        + navigator.getCurentMenu().getItems().size());
            }
        }
    }
}
