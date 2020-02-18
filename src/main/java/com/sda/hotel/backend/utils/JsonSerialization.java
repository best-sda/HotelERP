/*
 * Created by Dmitry Scherbakov in 05.01.2020, 17:09
 */

package com.sda.hotel.backend.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.List;

public final class JsonSerialization {

    private JsonSerialization() {
    }

    public static <T> void saveList(String path, List<T> o) {
        try (Writer writer = new FileWriter(path)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(o, writer);
            String jsonStr = new Gson().toJson(o);
            System.out.println(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <E> void loadList(String path) {
        try (Reader reader = new FileReader(path)) {
            List<E> list = new Gson().fromJson(reader, new TypeToken<List<E>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
