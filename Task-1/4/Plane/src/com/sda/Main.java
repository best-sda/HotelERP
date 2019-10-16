package com.sda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        ArrayList<Flight> flightList= new ArrayList<>();
        ArrayList<Ticket> allTicketList = new ArrayList <>();
        Plane plane = new Plane(1, "A320", 310);
 	    Dispatcher dispatcher = new Dispatcher("Кузнецов Игорь Леонидович", 20948,14091997, "male");
 	    flightList.add(dispatcher.setFlightByDispaycher("Москва", "Санкт петербург", "15102019", plane, plane.getCountOfSeats()) );
        System.out.println(flightList.get(0).getFreeSeatsOnFlight());
	    Passenger passenger = new Passenger("Зайцева Ольга Васильевна", 319754, 12181972, "female");
	    // dispatcher.cancelFlight(flightList.get(0));
        Ticket ticket = passenger.buyTicet(flightList.get(0));
	    allTicketList.add(ticket);
        System.out.println(flightList.get(0).getFreeSeatsOnFlight());
        System.out.println("Количество билетов у пасажира " +passenger.getFullName()+ " = " + passenger.getTicketList().size());
        System.out.println("Выкупленно билетов на рейс из " + flightList.get(0).getDeparturePoint() +" в "+ flightList.get(0).getArrivalPoint()+ " = " + flightList.get(0).getTiketList().size());
        System.out.println("Продано билетов: " + allTicketList.size());

        System.out.println("Список рейсов:");
        int i = 0;
        for (Iterator<Flight> it = flightList.iterator(); it.hasNext(); i++) {
            Flight flight = it.next();
            System.out.println("Рейс #"+ i + " из "+ flight.getDeparturePoint() + " в " + flight.getArrivalPoint() + " на "+ flight.getDate() + (flight.getFlightCancel()? " рейс отменен":""));
        }

    }
}
