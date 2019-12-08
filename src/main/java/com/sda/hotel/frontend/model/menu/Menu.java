/*
 * Created by Dmitry Scherbakov in 25.11.2019, 15:29
 */

package com.sda.hotel.frontend.model.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Menu {
    private String Name;
    private List<MenuItem> items;

    public Menu(String name, List <MenuItem> items) {
        Name = name;
        this.items = items;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List <MenuItem> getItems() {
        return items;
    }

    public void setItems(List <MenuItem> items) {
        this.items = items;
    }

    public void addItem(MenuItem item) {
        if(items == null){
            items = new ArrayList<>();
        }
        Optional.ofNullable(items).ifPresent(menuItems -> menuItems.add(item));
    }
}
