/*
 * Created by Dmitry Scherbakov in 25.11.2019, 15:27
 */

package com.sda.hotel.frontend.model.builder;

import com.sda.hotel.backend.annotation.Component;
import com.sda.hotel.frontend.model.menu.Menu;

@Component
public interface IBuilder {
    Menu buildMenu();
}
