package com.sda;

import java.lang.reflect.Field;

public class Ticket  {
    public int getTicketID() {
        return ticketID;
    }

    private int ticketID=0;
    private Flight flight;
    private Passenger passenger;

    public Ticket(Flight flight, Passenger passenger) {
        this.ticketID+=1;
        this.flight = flight;
        this.passenger = passenger;

    }


}
