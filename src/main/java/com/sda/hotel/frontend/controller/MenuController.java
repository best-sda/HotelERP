/*
 * Created by Dmitry Scherbakov in 25.11.2019, 15:32
 */

package com.sda.hotel.frontend.controller;

import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.frontend.exeption.MenuExeption;
import com.sda.hotel.frontend.model.builder.IBuilder;
import com.sda.hotel.frontend.model.navigator.Inavigator;
import com.sda.hotel.frontend.view.ViewController;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Scanner;

@Component
public class MenuController {
    @Autowired
    private IBuilder builder;
    @Autowired
    private Inavigator navigator;
    private Logger logger = LogManager.getLogger(MenuController.class);

    public void setBuilder(IBuilder builder) {
        this.builder = builder;
    }

    public void setNavigator(Inavigator navigator) {
        this.navigator = navigator;
    }

    public void run() {
        navigator.setCurentMenu(builder.buildMenu());
        ViewController.getInstance().print("Hotel program");
        while (true) {

            navigator.printMenu();
            Scanner scanner = new Scanner(System.in);
            int index = scanner.nextInt();
            try {
                navigator.navigate(index - 1);
            } catch (MenuExeption e) {
                logger.error("invalid number, shod be in range " + 1
                        + navigator.getCurentMenu().getItems().size() + e);
                ViewController.getInstance()
                        .print("invalid number, shod be in range " + 1
                                + navigator.getCurentMenu().getItems().size());
            }
        }
    }

}
