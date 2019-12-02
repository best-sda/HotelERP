/*
 * Created by Dmitry Scherbakov in 25.11.2019, 15:30
 */

package com.sda.hotel.frontend.model.navigator;

import com.sda.hotel.frontend.model.menu.Menu;

public interface Inavigator {
    Menu getCurentMenu();

    void setCurentMenu(Menu curentMenu);

    void printMenu();

    void navigate(Integer index);
}
