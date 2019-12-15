/*
 * Created by Dmitry Scherbakov in 12.12.2019, 16:57
 */

/*
 * Created by Dmitry Scherbakov in 02.12.2019, 16:15
 */

package com.sda.hotel.backend.utils;

import com.sda.hotel.backend.domain.Administrator;

import java.io.*;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

public class Utils {

//    public static void save() {
//        Administrator administrator = Administrator.getInstance();
//        saveList("serviceList.txt", administrator.getServiceList());
//        saveList("roomList.txt", administrator.getRoomList());
//        saveList("guestList.txt", administrator.getGuestList());
//    }


    public static <T> void saveList(String path, List <T> o) {
        try (FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static <E> void loadList(String path, List <E> list) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            list.addAll((Collection <? extends E>) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
