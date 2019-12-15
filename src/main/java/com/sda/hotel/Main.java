/*
 * Created by Dmitry Scherbakov in 25.11.2019, 15:36
 */

package com.sda.hotel;

import com.sda.hotel.frontend.controller.MenuController;
import com.sda.hotel.frontend.model.builder.Builder;
import com.sda.hotel.frontend.model.navigator.Navigator;

public class Main {
    public static void main(String[] args) {
        MenuController controller = new MenuController(new Builder(), new Navigator());
        controller.run();

    }

}
