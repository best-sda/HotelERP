package com.sda;

public class Dispatcher extends Person {
    public Dispatcher(String fullName, int IDCardNumber, int dateOfBirth, String sex) {
        super(fullName, IDCardNumber, dateOfBirth, sex);
    }

    Flight setFlightByDispaycher(String departurePoint, String arrivalPoint, String date, Plane plane, int freeSeatsOnFlight){
        Flight flight = new Flight(departurePoint, arrivalPoint, date, plane, freeSeatsOnFlight);
        return flight;
    }
    void cancelFlight(Flight flight){
        flight.setFlightCancel(true);
    }
}
