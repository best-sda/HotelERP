package com.sda;

import java.util.List;

public class SaveAndLoad {

    public static void save() throws IOException {
        Administrator administrator = Administrator.getInstance();
        FileOutputStream fos = new FileOutputStream("serviceList.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(administrator.serviceList);
        FileOutputStream fos2 = new FileOutputStream("roomList.txt");
        ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
        oos2.writeObject(administrator.roomList);
        FileOutputStream fos3 = new FileOutputStream("guestList.txt");
        ObjectOutputStream oos3 = new ObjectOutputStream(fos3);
        oos3.writeObject(administrator.guestList);
    }

    public static void load() throws IOException, ClassNotFoundException {
        Administrator administrator = Administrator.getInstance();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serviceList.txt"));
        administrator.serviceList = (List <Service>) ois.readObject();
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("roomList.txt"));
        administrator.roomList = (List <Room>) ois2.readObject();
        ObjectInputStream ois3 = new ObjectInputStream(new FileInputStream("guestList.txt"));
        administrator.guestList = (List <Guest>) ois3.readObject();
    }


}
