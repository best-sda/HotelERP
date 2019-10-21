package com.sda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

      Dispatcher dispatcher = Dispatcher.getInstance();
      dispatcher.createPlane(2, "A340", 218);
      dispatcher.setFlight(1, "Москва", "Санкт петербург", "15102019", 2);
      dispatcher.setFlight(2, "Самара", "Оренбург", "15102019", 2);
      dispatcher.createPassanger("Семилетова Ольга Васильевна", 313754, 12181987, "female");
      dispatcher.createPassanger("Зайцева Ольга Васильевна", 313754, 12181987, "female");
      dispatcher.addTiclet(1, "Зайцева Ольга Васильевна", 1);
      dispatcher.addTiclet(2, "Семилетова Ольга Васильевна", 2);
      dispatcher.cancelTicket("Семилетова Ольга Васильевна", 2);
      System.out.println("Список рейсов: ");
      dispatcher.printFlightList();

    }
}
