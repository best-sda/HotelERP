/*
 * Created by Dmitry Scherbakov in 25.11.2019, 15:36
 */

package com.sda.hotel;

import com.sda.hotel.backend.controller.EmailController;
import com.sda.hotel.backend.utils.BeanFactory;
import com.sda.hotel.frontend.controller.MenuController;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class Main {

    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(Main.class);
        logger.trace("App start");
        logger.trace("Creating beanfactory");
        BeanFactory beanFactory = BeanFactory.getInstance();
        beanFactory.instantiate("com.sda.hotel");
        beanFactory.populateProperties();
        logger.trace("get bean menuController");
        MenuController controller = (MenuController) beanFactory
                .getBean("menuController");
        logger.trace("get bean emailController");
      //  EmailController emailController = (EmailController) beanFactory
        //        .getBean("emailController");
        Thread.currentThread().setName("mainThread");
        logger.info("Start email sender");
       // emailController.start();
        logger.info("Run controller");
        controller.run();
        logger.trace("App stopped");
    }

}
