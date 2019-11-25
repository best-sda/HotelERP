/*
 * Created by Dmitry Scherbakov in 25.11.2019, 15:32
 */

package com.sda.hotel.frontend.controller;

import com.sda.hotel.frontend.model.builder.IBuilder;
import com.sda.hotel.frontend.model.navigator.Inavigator;

public class MenuController {
    private IBuilder builder;
    private Inavigator navigator;

    public MenuController(IBuilder builder, Inavigator navigator) {
        this.builder = builder;
        this.navigator = navigator;
    }

    public void run() {
        builder.buildMenu();
        while (true){

        }
    }
}
