package com.project;

public class PassengerDetails {
    private String PassengerID;
    private String PassengerFirstName;
    private String PassengerLastName;
    private String Gender;
    private int PassengerPhoneNo;
    private String PassengerEmailID;
    private String DateofTravel;
    private String FlightNo;
    private String Origin;
    private String Destination;
    private int SeatNo;

    public PassengerDetails() {
    }

    public String getPassengerID(){
        return PassengerID;
    }
    public void setPassengerID(String PassengerID){
        this.PassengerID = PassengerID;
    }
    public String getPassengerFirstName() {
        return PassengerFirstName;
    }

    public void setPassengerFirstName(String PassengerFirstName) {
        this.PassengerFirstName = PassengerFirstName;
    }

    public String getPassengerLastName() {
        return PassengerLastName;
    }

    public void setPassengerLastName(String PassengerLastName) {
        this.PassengerLastName = PassengerLastName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public int getPassengerPhoneNo() {
        return PassengerPhoneNo;
    }

    public void setPassengerPhoneNo(int PassengerPhoneNo) {
        this.PassengerPhoneNo = PassengerPhoneNo;
    }

    public String getPassengerEmailID() {
        return PassengerEmailID;
    }

    public void setPassengerEmailID(String PassengerEmailID) {
        this.PassengerEmailID = PassengerEmailID;
    }

    public String getDateofTravel() {
        return DateofTravel;
    }

    public void setDateofTravel(String DateofTravel) {
        this.DateofTravel = DateofTravel;
    }

    public String getFlightNo() {
        return FlightNo;
    }

    public void setFlightNo(String FlightNo) {
        this.FlightNo = FlightNo;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public int getSeatNo() {
        return SeatNo;
    }

    public void setSeatNo(int SeatNo) {
        this.SeatNo = SeatNo;
    }

    @Override
    public String toString() {
        return "PassengerDetails{" +
                "PassengerID='" + PassengerID + '\'' +
                ", PassengerFirstName='" + PassengerFirstName + '\'' +
                ", PassengerLastName='" + PassengerLastName + '\'' +
                ", Gender='" + Gender + '\'' +
                ", PassengerPhoneNo=" + PassengerPhoneNo +
                ", PassengerEmailID='" + PassengerEmailID + '\'' +
                ", DateofTravel='" + DateofTravel + '\'' +
                ", FlightNo='" + FlightNo + '\'' +
                ", Origin='" + Origin + '\'' +
                ", Destination='" + Destination + '\'' +
                ", SeatNo=" + SeatNo +
                '}';
    }
}
