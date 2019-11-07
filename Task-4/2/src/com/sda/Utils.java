package com.sda;

import java.io.*;
import java.util.Collection;
import java.util.List;

public class Utils {

    public static void save() {
        Administrator administrator = Administrator.getInstance();
        loadList("serviceList.txt", administrator.getServiceList());
        loadList("roomList.txt", administrator.getRoomList());
        loadList("guestList.txt", administrator.getGuestList());

    }


    private static <T> void loadList(String path, List <T> o) {
        try (FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(o);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load() {
        Administrator administrator = Administrator.getInstance();
        saveList("servicelist.txt", administrator.getServiceList());
        saveList("roomList.txt", administrator.getRoomList());
        saveList("guestList.txt", administrator.getGuestList());

    }

    private static <E> void saveList(String path, List <E> list) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            list.addAll((Collection <? extends E>) ois.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
