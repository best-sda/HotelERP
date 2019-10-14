package com.sda;

import java.lang.reflect.Field;

public class Ticket  {
    int ticketID=0;
    Flight flight;
    Passenger passenger;

    public Ticket(Flight flight, Passenger passenger) {
        this.ticketID+=1;
        this.flight = flight;
        this.passenger = passenger;

    }


}
