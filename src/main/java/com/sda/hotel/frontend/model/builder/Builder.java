/*
 * Created by Dmitry Scherbakov in 25.11.2019, 15:28
 */

package com.sda.hotel.frontend.model.builder;

import com.sda.hotel.frontend.model.menu.Menu;
import com.sda.hotel.frontend.model.menu.MenuItem;

import java.util.Arrays;

public class Builder implements IBuilder {
    private Menu rootMenu;

    public Builder() {
        rootMenu = new Menu("Root menu", null);
    }

    @Override
    public void buildMenu() {
        MenuItem addRoomItem = new MenuItem("Add room", rootMenu, null);
        MenuItem deleteRoomItem = new MenuItem("Del room", rootMenu, null);
        MenuItem showAllRoomItem = new MenuItem("Wiew room list", rootMenu, null);

        Menu roomMenu = new Menu("Rooom", Arrays.asList(addRoomItem, deleteRoomItem, showAllRoomItem));
        Menu guestMenu = new Menu("Guest", null);
        Menu serviceMenu = new Menu("Service", null);

        //rootMenu.addItem(roomMenu);
       // rootMenu.addItem(guestMenu);
        //rootMenu.addItem(serviceMenu);

    }
}
