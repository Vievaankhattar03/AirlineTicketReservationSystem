package com.project;

import java.util.Date;

public class BookingDetails {
    private String PassengerID;
    private String PassengerFirstName;
    private String PassengerLastName;
    private String DateofTravel;
    private String FlightNo;
    private String Origin;
    private String Destination;
    private double Price;
    private int SeatNo;

    public BookingDetails() {
    }

    public String getPassengerID(){
        return PassengerID;
    }
    public void setPassengerID(String PassengerID){
        this.PassengerID = PassengerID;
    }

    public String getPassengerFirstName(){
        return PassengerFirstName;
    }
    public void setPassengerFirstName(String PassengerFirstName){
        this.PassengerFirstName = PassengerFirstName;
    }

    public String getPassengerLastName(){
        return PassengerLastName;
    }
    public void setPassengerLastName(String PassengerLastName){
        this.PassengerLastName = PassengerLastName;
    }

    public String getDateofTravel(){
        return DateofTravel;
    }
    public void setDateofTravel(String DateofTravel){
        this.DateofTravel = DateofTravel;
    }

    public String getFlightNo(){
        return FlightNo;
    }
    public void setFlightNo(String FlightNo){
        this.FlightNo = FlightNo;
    }

    public String getOrigin(){
        return Origin;
    }
    public void setOrigin(String Origin){
        this.Origin = Origin;
    }

    public String getDestination(){
        return Destination;
    }
    public void setDestination(String Destination){
        this.Destination = Destination;
    }

    public double getPrice(){
        return Price;
    }
    public void setPrice(double Price){
        this.Price = Price;
    }

    public int getSeatNo(){
        return SeatNo;
    }
    public void setSeatNo(int SeatNo){
        this.SeatNo = SeatNo;
    }

    @Override
    public String toString() {
        return "BookingDetails{" +
                "PassengerID='" + PassengerID + '\'' +
                ", PassengerFirstName='" + PassengerFirstName + '\'' +
                ", PassengerLastName='" + PassengerLastName + '\'' +
                ", DateofTravel='" + DateofTravel + '\'' +
                ", FlightNo='" + FlightNo + '\'' +
                ", Origin='" + Origin + '\'' +
                ", Destination='" + Destination + '\'' +
                ", Price=" + Price +
                ", SeatNo=" + SeatNo +
                '}';
    }
}
