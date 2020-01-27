/*
 * Created by Dmitry Scherbakov in 20.01.2020, 13:52
 */

package com.sda.hotel.frontend.model.action;

import com.sda.hotel.backend.Application;
import com.sda.hotel.backend.annotation.Autowired;
import com.sda.hotel.backend.annotation.Component;

public abstract class ActionNewThred extends Thread implements IAction {

    @Override

    public void run() {
        synchronized (this) {
            if (!Thread.interrupted()) {
                this.execute();
            }
        }
    }

}
