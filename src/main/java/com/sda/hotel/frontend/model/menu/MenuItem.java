/*
 * Created by Dmitry Scherbakov in 25.11.2019, 15:29
 */

package com.sda.hotel.frontend.model.menu;

import com.sda.hotel.frontend.model.action.IAction;

import java.util.Optional;

public class MenuItem {
    private String title;
    private IAction action;
    private Menu nextMenu;

    public MenuItem(String title,Menu nextMenu, IAction action ) {
        this.title = title;
        this.action = action;
        this.nextMenu = nextMenu;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public IAction getAction() {
        return action;
    }

    public void setAction(IAction action) {
        this.action = action;
    }

    public Menu getNextMenu() {
        return nextMenu;
    }

    public void setNextMenu(Menu nextMenu) {
        this.nextMenu = nextMenu;
    }

}
