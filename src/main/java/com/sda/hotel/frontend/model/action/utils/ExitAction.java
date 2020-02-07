package com.sda.hotel.frontend.model.action.utils;

import com.sda.hotel.frontend.model.action.ActionNewThred;

import java.util.Map;

public class ExitAction extends ActionNewThred {
    @Override
    public void execute() {
        Map<Thread, StackTraceElement[]> threads = Thread.getAllStackTraces();
        for (Thread thread : threads.keySet()) {
            if (thread.getName().equals("mainThread")
                    || thread.getName().equals("emailController")) {
                thread.interrupt();
            }
        }
        System.exit(0);
    }
}
