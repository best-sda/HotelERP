package com.sda;

import java.util.ArrayList;

public class Passenger extends Person {
    public Passenger(String fullName, int IDCardNumber, int dateOfBirth, String sex) {
        super(fullName, IDCardNumber, dateOfBirth, sex);
    }

    public ArrayList <Ticket> getTicketList() {
        return ticketList;
    }

    private ArrayList<Ticket> ticketList = new ArrayList <>();
 public Ticket buyTicet(Flight flight){
       if (checkAvalibleSeats(flight)  && flight.getFlightCancel()== false){
        Ticket ticket = new Ticket(flight, this);
        ticketList.add(ticket);
        flight.addToTiketList(ticket);
       flight.setFreeSeatsOnFlight(flight.getFreeSeatsOnFlight()-1);
           System.out.println("Вы получили билет #"+ ticket.getTicketID());
        return ticket;
       }
       else{
           System.out.println("Сори, нет мест, или регистрация на рейс закрыта");
           return null;
       }

   }
    Boolean checkAvalibleSeats(Flight flight){
        if (flight.getFreeSeatsOnFlight()> 0) return true;
        else return false;
    }
}
