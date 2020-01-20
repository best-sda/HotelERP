/*
 * Created by Dmitry Scherbakov in 25.11.2019, 15:36
 */

package com.sda.hotel;

import com.sda.hotel.backend.controller.EmailController;
import com.sda.hotel.backend.repository.GuestRepisitory;
import com.sda.hotel.backend.utils.BeanFactory;
import com.sda.hotel.frontend.controller.MenuController;

public class Main {
    public static void main(String[] args) {
        BeanFactory beanFactory = BeanFactory.getInstance();
        beanFactory.instantiate("com.sda.hotel.repository");
        beanFactory.instantiate("com.sda.hotel");
        beanFactory.populateProperties();
        MenuController controller = (MenuController) beanFactory.getBean("menuController");
        EmailController emailController = (EmailController) beanFactory.getBean("emailController") ;
        emailController.start();
        controller.run();

    }

}
