package com.sda;

import java.util.ArrayList;

public class Flight {

    private int flightID;
    private String departurePoint ;
    private String arrivalPoint;
    private String date;
    private Boolean flightDelay;
    private Plane plane;
    private int freeSeatsOnFlight;
    private Boolean flightCancel;

    public void addToTiketList(Ticket ticket) {
        tiketList.add(ticket);
    }

    private ArrayList<Ticket> tiketList = new ArrayList <>();

    public ArrayList <Ticket> getTiketList() {
        return tiketList;
    }

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

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public Flight(int flightID, String departurePoint, String arrivalPoint, String date, Plane plane, int freeSeatsOnFlight) {
        this.flightID = flightID;
        this.departurePoint = departurePoint;
        this.arrivalPoint = arrivalPoint;
        this.date = date;
        this.plane = plane;
        this.freeSeatsOnFlight = freeSeatsOnFlight;
        this.flightCancel = false;
        this.flightDelay = false;
    }


}
