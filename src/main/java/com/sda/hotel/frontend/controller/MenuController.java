/*
 * Created by Dmitry Scherbakov in 25.11.2019, 15:32
 */

package com.sda.hotel.frontend.controller;

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
        while (true){
            ViewController.getInstance().print("Hotel program");
            navigator.printMenu();

            try (Scanner scanner = new Scanner(System.in)) {
                Integer index = scanner.nextInt();

                Optional.ofNullable(navigator.getCurentMenu().getItems().get(index-1)).ifPresent(action ->{
                    action.getAction().execute();
                });
                navigator.navigate(index);
            }
        }
    }
}
