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

public class Utils {
    //TODO replase with json

//    public static void save() {
//        Administrator administrator = Administrator.getInstance();
//        saveList("serviceList.txt", administrator.getServiceList());
//        saveList("roomList.txt", administrator.getRoomList());
//        saveList("guestList.txt", administrator.getGuestList());
//    }
//
//
//    private static <T> void saveList(String path, List <T> o) {
//        try (FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//            oos.writeObject(o);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void load() {
//        Administrator administrator = Administrator.getInstance();
//        loadList("servicelist.txt", administrator.getServiceList());
//        loadList("roomList.txt", administrator.getRoomList());
//        loadList("guestList.txt", administrator.getGuestList());
//    }
//
//    private static <E> void loadList(String path, List <E> list) {
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
//            list.addAll((Collection <? extends E>) ois.readObject());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

//    FileInputStream fis;
//    Properties property = new Properties();
//
//        try {
//        fis = new FileInputStream("src/main/resources/config.properties");
//        property.load(fis);
//
//        String host = property.getProperty("db.host");
//        String login = property.getProperty("db.login");
//        String password = property.getProperty("db.password");
//
//        System.out.println("HOST: " + host
//                + ", LOGIN: " + login
//                + ", PASSWORD: " + password);
//
//    } catch (IOException e) {
//        System.err.println("ОШИБКА: Файл свойств отсуствует!");
//    }

}
