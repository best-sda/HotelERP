/*
 * Created by Dmitry Scherbakov in 12.12.2019, 16:57
 */

package com.sda.hotel.backend.utils;

import java.io.*;
import java.util.Collection;
import java.util.List;

public final class JavaSerialization {

    private void javaSerialisation() {
    }

    public static <T> void saveList(String path, List<T> o) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <E> void loadList(String path, List<E> list) {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(path))) {
            list.addAll((Collection<? extends E>) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
