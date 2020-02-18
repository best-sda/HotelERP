/*
 * Created by Dmitry Scherbakov in 20.01.2020, 17:12
 */

package com.sda.hotel.frontend.model.action.utils;

import com.sda.hotel.backend.controller.EmailController;
import com.sda.hotel.backend.utils.BeanFactory;
import com.sda.hotel.frontend.model.action.ActionNewThred;

public class StopMessagingAction extends ActionNewThred {
    @Override
    public void execute() {
        EmailController emailController = (EmailController) BeanFactory
                .getInstance().getBean("emailController");
        emailController.interrupt();
    }
}
