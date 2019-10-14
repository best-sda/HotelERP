package com.sda;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Flight> flightList= new ArrayList<>();
        Plane plane = new Plane(1, "A320", 310);
 	    Dispatcher dispatcher = new Dispatcher("Кузнецов Игорь Леонидович", 20948,14091997, "male");
 	    flightList.add(dispatcher.setFlightByDispaycher("Москва", "Санкт петербург", "15102019", plane, plane.getCountOfSeats()) );
        System.out.println(flightList.get(0).getFreeSeatsOnFlight());
	    Passenger passenger = new Passenger("Зайцева Ольга Васильевна", 319754, 12181972, "female");
	    //dispatcher.cancelFlight(flightList.get(0));
	    passenger.buyTicet(flightList.get(0));
        System.out.println(flightList.get(0).getFreeSeatsOnFlight());
    }
}
