/*
 * Created by Dmitry Scherbakov in 15.12.2019, 21:13
 */

package com.sda.hotel.frontend.model.action.utils;

import com.sda.hotel.backend.Application;
import com.sda.hotel.backend.service.UtilsService;
import com.sda.hotel.backend.service.UtilsServiceImpl;
import com.sda.hotel.backend.utils.BeanFactory;
import com.sda.hotel.frontend.model.action.ActionNewThred;
import com.sda.hotel.frontend.model.action.IAction;

public class SaveFileAction extends ActionNewThred {

    @Override
    public void execute() {
        UtilsService utilsService = new UtilsServiceImpl();
        utilsService.saveBase();
    }

}
