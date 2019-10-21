package com.sda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dispatcher  {
    private static Dispatcher instance;
    List <Flight> flightList= new ArrayList<>();
    List <Ticket> allTicketList = new ArrayList <>();
    List <Passenger> allPassangerList = new ArrayList <>();
    List <Plane> planeList = new ArrayList <>();

    public static Dispatcher getInstance() {
        if (instance == null) {
            instance = new Dispatcher();
        }
        return instance;
    }
    private Dispatcher() {}

    Flight setFlight(int flightID, String departurePoint, String arrivalPoint, String date, int planeID){
        Plane plane = planeList.stream().filter(a ->a.getPlaneID() == planeID).findFirst().orElse(null);
        int freeSeatsOnFlight = plane.getCountOfSeats();
        Flight flight = new Flight(flightID, departurePoint, arrivalPoint, date, plane, freeSeatsOnFlight);
        flightList.add(flight);
        return flight;
    }
    void cancelFlight(Flight flight){
        flight.setFlightCancel(true);
    }
    void flightDelay(Flight flight) {flight.setFlightDelay(true);}

    void cancelTicket(String passengerFullName, int flightID) {
        Flight flight = flightList.stream().filter(a -> a.getFlightID() == flightID).findFirst().orElse(null);
        Passenger passenger = allPassangerList.stream().filter(a->a.getFullName() == passengerFullName)
                .findFirst().orElse(null);
        allTicketList.remove(allTicketList.stream().filter(a -> a.getPassenger().equals(passenger)
                && a.getFlight().equals(flight)).findFirst().orElse(null));
    }

    Ticket addTiclet(int id, String passengerFullName, int flightID){
       Flight flight = flightList.stream().filter(a -> a.getFlightID() == flightID).findFirst().orElse(null);
       Passenger passenger = allPassangerList.stream().filter(a->a.getFullName() == passengerFullName)
               .findFirst().orElse(null);
       if (checkAvalibleSeats(flight)  && flight.getFlightCancel()== false){
            Ticket ticket = new Ticket(id,flight, passenger);
            allTicketList.add(ticket);
            flight.addToTiketList(ticket);
            flight.setFreeSeatsOnFlight(flight.getFreeSeatsOnFlight()-1);
            System.out.println("Выдан билет"+ ticket.getTicketID());
            return ticket;
        }
        else{
            System.out.println("Нет мест, или регистрация на рейс закрыта");
            return null;
        }
    }

    void printFlightList (){
        int i = 0;
        for (Iterator <Flight> it = flightList.iterator(); it.hasNext(); i++) {
            Flight flight = it.next();
            System.out.println("Рейс #"+ i + " из "+ flight.getDeparturePoint() + " в " + flight.getArrivalPoint() +
                    " на "+ flight.getDate() + (flight.getFlightCancel()? " рейс отменен":"") +
                    (flight.getFlightDelay()? "Рейс перенесен" : "" ));
        }

    }

    Boolean checkAvalibleSeats(Flight flight){

        if (flight.getFreeSeatsOnFlight()> 0) return true;
        else return false;

    }

    Plane createPlane (int planeID, String name, int countOfSeats){

        Plane plane = new Plane(planeID, name, countOfSeats);
        planeList.add(plane);
        return plane;

    }

    Passenger createPassanger (String fullName, int IDCardNumber, int dateOfBirth, String sex){
        Passenger passenger = new Passenger(fullName, IDCardNumber, dateOfBirth, sex);
        allPassangerList.add(passenger);
        return passenger;
    }


}
