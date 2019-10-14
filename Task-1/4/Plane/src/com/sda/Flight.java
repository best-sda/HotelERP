package com.sda;

public class Flight {
    String departurePoint ;
    String arrivalPoint;
    String date;
    Boolean flightDelay;


    public Boolean getFlightDelay() {
        return flightDelay;
    }

    public void setFlightDelay(Boolean flightDelay) {
        this.flightDelay = flightDelay;
    }

    public Boolean getFlightCancel() {
        return flightCancel;
    }

    public void setFlightCancel(Boolean flightCancel) {
        this.flightCancel = flightCancel;
    }

    Boolean flightCancel;

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getArrivalPoint() {
        return arrivalPoint;
    }

    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public int getFreeSeatsOnFlight() {
        return freeSeatsOnFlight;
    }

    public void setFreeSeatsOnFlight(int freeSeatsOnFlight) {
        this.freeSeatsOnFlight = freeSeatsOnFlight;
    }

    Plane plane;
    int freeSeatsOnFlight;

    public Flight(String departurePoint, String arrivalPoint, String date, Plane plane, int freeSeatsOnFlight) {
        this.departurePoint = departurePoint;
        this.arrivalPoint = arrivalPoint;
        this.date = date;
        this.plane = plane;
        this.freeSeatsOnFlight = freeSeatsOnFlight;
        this.flightCancel = false;
        this.flightDelay = false;
    }


}
