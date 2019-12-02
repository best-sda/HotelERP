/*
 * Created by Dmitry Scherbakov in 02.12.2019, 15:03
 */

package com.sda.hotel.frontend.view;

import java.util.List;
import java.util.Optional;

public class ViewController {
    private  static ViewController instance;

    public static ViewController getInstance() {
        if (instance == null){
            instance = new ViewController();
        }
        return instance;
    }

    public void print(String value) {

    }

    public void printList(List<String> list) {
        for (int i = 0; i < list.size() ; i++) {
            System.out.println((i + 1 ) + ": " + list.get(i));
        }
    }
}
