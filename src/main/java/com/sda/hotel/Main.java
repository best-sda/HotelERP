/*
 * Created by Dmitry Scherbakov in 25.11.2019, 15:36
 */

package com.sda.hotel;

import com.sda.hotel.backend.utils.BeanFactory;
import com.sda.hotel.frontend.controller.MenuController;

public class Main {
    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.instantiate("com.sda.hotel");
        beanFactory.populateProperties();
        MenuController controller = (MenuController) beanFactory.getBean("menuController");
        controller.run();
    }

}
