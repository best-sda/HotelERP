/*
 * Created by Dmitry Scherbakov in 25.11.2019, 15:28
 */

package com.sda.hotel.frontend.model.builder;

import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.frontend.model.action.administration.CheckinAction;
import com.sda.hotel.frontend.model.action.administration.ChekoutAction;
import com.sda.hotel.frontend.model.action.administration.SetServiceAction;
import com.sda.hotel.frontend.model.action.guest.AddGuestAction;
import com.sda.hotel.frontend.model.action.guest.DelGuestAction;
import com.sda.hotel.frontend.model.action.guest.ShowGuestAction;
import com.sda.hotel.frontend.model.action.room.AddRoomAction;
import com.sda.hotel.frontend.model.action.room.DelRoomAction;
import com.sda.hotel.frontend.model.action.room.ShowRoomAction;
import com.sda.hotel.frontend.model.action.service.AddServiceAction;
import com.sda.hotel.frontend.model.action.service.DelServiceAction;
import com.sda.hotel.frontend.model.action.service.ShowServiceAction;
import com.sda.hotel.frontend.model.action.utils.ExitAction;
import com.sda.hotel.frontend.model.action.utils.LoadFileAction;
import com.sda.hotel.frontend.model.action.utils.SaveFileAction;
import com.sda.hotel.frontend.model.action.utils.StopMessagingAction;
import com.sda.hotel.frontend.model.menu.Menu;
import com.sda.hotel.frontend.model.menu.MenuItem;

import java.util.Arrays;

@Component
public class Builder implements IBuilder {

    private Menu rootMenu;

    public Builder() {
        rootMenu = new Menu("Root menu", null);
    }

    @Override
    public Menu buildMenu() {
        MenuItem addRoomItem = new MenuItem("Add room", rootMenu, new AddRoomAction());
        MenuItem deleteRoomItem = new MenuItem("Del room", rootMenu, new DelRoomAction());
        MenuItem showAllRoomItem = new MenuItem("Wiew room list", rootMenu, new ShowRoomAction());

        MenuItem addGuestItem = new MenuItem("Add guest", rootMenu, new AddGuestAction());
        MenuItem deleteGuestItem = new MenuItem("Del guest", rootMenu, new DelGuestAction());
        MenuItem showGuestItem = new MenuItem("Wiew guests", rootMenu, new ShowGuestAction());

        MenuItem addServiceItem = new MenuItem("Add service", rootMenu, new AddServiceAction());
        MenuItem deleteServiceItem = new MenuItem("Del service", rootMenu, new DelServiceAction());
        MenuItem showServiceItem = new MenuItem("Wiew services", rootMenu, new ShowServiceAction());

        MenuItem checkinItem = new MenuItem("Check-in guests to room", rootMenu, new CheckinAction());
        MenuItem setServiceItem = new MenuItem("Set service to room", rootMenu, new SetServiceAction());
        MenuItem cancelRegistrationItem = new MenuItem("Сheck-out gusest", rootMenu,new ChekoutAction());

        MenuItem loadFileItem = new MenuItem("Load base", rootMenu, new LoadFileAction());
        MenuItem saveFileItem = new MenuItem("Save base", rootMenu, new SaveFileAction());

        MenuItem exitItem = new MenuItem("Exit", rootMenu, new ExitAction());
        MenuItem stopMessegingItem = new MenuItem("Stop messeging", rootMenu, new StopMessagingAction());

        Menu roomMenu = new Menu("Rooom", Arrays.asList(addRoomItem, deleteRoomItem, showAllRoomItem));
        Menu guestMenu = new Menu("Guest", Arrays.asList(addGuestItem, deleteGuestItem, showGuestItem));
        Menu serviceMenu = new Menu("Service", Arrays.asList(addServiceItem, deleteServiceItem, showServiceItem));
        Menu administrationMenu = new Menu("administration", Arrays.asList(checkinItem, setServiceItem, cancelRegistrationItem));
        Menu saveMenu = new Menu("Save/Load", Arrays.asList(loadFileItem, saveFileItem));
        Menu exitMenu = new Menu("Exit", Arrays.asList(exitItem, stopMessegingItem));

        rootMenu.addItem(new MenuItem(roomMenu.getName(), roomMenu, null));
        rootMenu.addItem(new MenuItem(guestMenu.getName(), guestMenu, null));
        rootMenu.addItem(new MenuItem(serviceMenu.getName(), serviceMenu, null));
        rootMenu.addItem(new MenuItem(administrationMenu.getName(), administrationMenu, null));
        rootMenu.addItem(new MenuItem(saveMenu.getName(), saveMenu, null));
        rootMenu.addItem(new MenuItem(exitMenu.getName(), exitMenu, null));

        return rootMenu;
    }
}
