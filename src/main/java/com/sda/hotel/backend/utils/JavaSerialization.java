/*
 * Created by Dmitry Scherbakov in 12.12.2019, 16:57
 */

package com.sda.hotel.backend.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Collection;
import java.util.List;

public final class JavaSerialization {

    private static Logger logger = LogManager.getLogger(JavaSerialization.class);

    private void javaSerialisation() {
    }

    public static <T> void saveList(String path, List<T> o) {
        logger.trace("try to save" + path);
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(o);
        } catch (IOException e) {
            logger.error(e.getStackTrace());
        }
    }

    public static <E> void loadList(String path, List<E> list) {
        logger.trace("try to load" + path);
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(path))) {
            list.addAll((Collection<? extends E>) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            logger.error(e.getStackTrace());
        }
    }

}
