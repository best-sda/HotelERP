package com.sda;

public class Passenger extends Person {
    public Passenger(String fullName, int IDCardNumber, int dateOfBirth, String sex) {
        super(fullName, IDCardNumber, dateOfBirth, sex);
    }
   Ticket buyTicet(Flight flight){
       if (checkAvalibleSeats(flight)  && flight.getFlightCancel()== false){
        Ticket ticket = new Ticket(flight, this);

       flight.setFreeSeatsOnFlight(flight.getFreeSeatsOnFlight()-1);
           System.out.println("Вы получили билет #"+ ticket.ticketID);
        return ticket;
       }
       else{
           System.out.println("Сори, нет мест, или регистрация на рейс закрыта");
           return null;
       }

   }
    Boolean checkAvalibleSeats(Flight flight){
        if (flight.freeSeatsOnFlight > 0) return true;
        else return false;
    }
}
