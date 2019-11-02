package com.sda;

import java.util.List;

public class SaveAndLoad {

    public static void save() {
        Administrator administrator = Administrator.getInstance();
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("serviceList.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(administrator.serviceList);
            fos = new FileOutputStream("roomList.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(administrator.roomList);
            fos = new FileOutputStream("guestList.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(administrator.guestList);

        } catch (IOException e) {
            System.out.println("не удалось сохранить данные в файл");
            e.printStackTrace();
        }

    }

    public static void load() {
        Administrator administrator = Administrator.getInstance();
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("serviceList.txt"));
            administrator.serviceList = (List <Service>) ois.readObject();
            ois = new ObjectInputStream(new FileInputStream("roomList.txt"));
            administrator.roomList = (List <Room>) ois.readObject();
            ois = new ObjectInputStream(new FileInputStream("guestList.txt"));
            administrator.guestList = (List <Guest>) ois.readObject();
        } catch (IOException e) {
            System.out.println("не удалось загрузить данные из файла");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("не удалось загрузить данные из файла");
            e.printStackTrace();
        }

    }


}
