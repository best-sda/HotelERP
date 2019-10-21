package com.sda;

import java.lang.reflect.Field;

public class Ticket  {
    public int getTicketID() {
        return ticketID;
    }

    private int ticketID=0;
    private Flight flight;
    private Passenger passenger;

    public Ticket(int ticketID, Flight flight, Passenger passenger) {
        this.ticketID = ticketID;
        this.flight = flight;
        this.passenger = passenger;

    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
