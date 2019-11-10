package com.sda;

import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        MyCollection <String> collection = new MyCollection();
        for (int i = 0; i < 10000000; i++) {
            collection.add(new String("Hello world"));
        }
        MyCollection <Double> collection2 = new MyCollection();
        Random random = new Random();
        for (int i = 0; i < 10000000; i++) {
            collection2.add(random.nextDouble());
        }
        System.in.read();
    }

}
