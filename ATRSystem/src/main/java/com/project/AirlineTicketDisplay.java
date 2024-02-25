package com.project;

import java.sql.*;
import java.util.Scanner;

public class AirlineTicketDisplay {
    Connection con;
    Statement st;
    PreparedStatement pst;
    ResultSet rs;
    PassengerDetails t1;
    FlightDetails f1;
    BookingDetails b1;

    public AirlineTicketDisplay() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atrsystem", "root", "toor");
            System.out.println("Connection Successfully Established with Airline Database");
        } catch (Exception ex) {
            System.out.println("Error in Establishing Connection." + ex);
        }
    }

    public void showPassenger() {
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from passengerdetails");
            System.out.println("Result set successfully established.");
            while (rs.next()) {
                t1 = new PassengerDetails();
                t1.setPassengerID(rs.getString("PassengerID"));
                t1.setPassengerFirstName(rs.getString("PassengerFirstName"));
                t1.setPassengerLastName(rs.getString("PassengerLastName"));
                t1.setGender(rs.getString("Gender"));
                t1.setPassengerPhoneNo(rs.getInt("PassengerPhoneNo"));
                t1.setPassengerEmailID(rs.getString("PassengerEmailID"));
                t1.setDateofTravel(rs.getString("DateofTravel"));
                t1.setFlightNo(rs.getString("FlightNo"));
                t1.setOrigin(rs.getString("Origin"));
                t1.setDestination(rs.getString("Destination"));
                t1.setSeatNo(rs.getInt("SeatNo"));
                System.out.println(t1);
            }
        } catch (Exception ex1) {
            System.out.println("Error in Passing SQL Statement" + ex1);
        }
    }

    public void addPassenger(PassengerDetails mypassengerdetails) {
        try {
            pst = con.prepareStatement("insert into passengerdetails(PassengerID, PassengerFirstName, PassengerLastName, Gender, PassengerPhoneNo, PassengerEmailID, DateofTravel, FlightNo, Origin, Destination, SeatNo) values(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, mypassengerdetails.getPassengerID());
            pst.setString(2, mypassengerdetails.getPassengerFirstName());
            pst.setString(3, mypassengerdetails.getPassengerLastName());
            pst.setString(4, mypassengerdetails.getGender());
            pst.setInt(5, mypassengerdetails.getPassengerPhoneNo());
            pst.setString(6, mypassengerdetails.getPassengerEmailID());
            pst.setString(7, mypassengerdetails.getDateofTravel());
            pst.setString(8, mypassengerdetails.getFlightNo());
            pst.setString(9, mypassengerdetails.getOrigin());
            pst.setString(10, mypassengerdetails.getDestination());
            pst.setInt(11, mypassengerdetails.getSeatNo());
            int row = pst.executeUpdate();
            if (row == 1) {
                System.out.println("Row inserted Successfully.");
            }
        } catch (Exception ex2) {
            System.out.println("Insert Error" + ex2);
        }
    }

    public void showFlight() {
        try {
            st = con.createStatement();
            rs = st.executeQuery("select * from flightdetails");
            System.out.println("Result set successfully established.");
            while (rs.next()) {
                f1 = new FlightDetails();
                f1.setFlightNo(rs.getString("FlightNo"));
                f1.setOrigin(rs.getString("Origin"));
                f1.setDestination(rs.getString("Destination"));
                f1.setFlightTime(rs.getString("FlightTime"));
                f1.setTypeofFlight(rs.getString("TypeofFlight"));
                f1.setNoofSeats(rs.getInt("NoofSeats"));
                f1.setPrice(rs.getDouble("Price"));
                System.out.println(f1);
            }
        } catch (Exception ex3) {
            System.out.println("Error in Passing SQL Statement" + ex3);
        }
    }

    public void addFlight(FlightDetails myflightdetails) {
        try {
            pst = con.prepareStatement("insert into flightdetails(FlightNo, Origin, Destination, FlightTime, TypeofFlight, NoofSeats, Price) values(?,?,?,?,?,?,?)");
            pst.setString(1, myflightdetails.getFlightNo());
            pst.setString(2, myflightdetails.getOrigin());
            pst.setString(3, myflightdetails.getDestination());
            pst.setString(4, myflightdetails.getFlightTime());
            pst.setString(5, myflightdetails.getTypeofFlight());
            pst.setInt(6, myflightdetails.getNoofSeats());
            pst.setDouble(7, myflightdetails.getPrice());
            int row = pst.executeUpdate();
            if (row == 1) {
                System.out.println("Row inserted Successfully.");
            }
        } catch (Exception ex4) {
            System.out.println("Insert Error" + ex4);
        }
    }

    public void searchPassenger(String PassengerID) {
        try {
            pst = con.prepareStatement("Select * from passengerdetails where PassengerID=?");
            BookingDetails b2 = new BookingDetails();
            pst.setString(1, PassengerID);
            rs = pst.executeQuery();
            while (rs.next()) {
                b2.setPassengerID(rs.getString("PassengerID"));
                b2.setPassengerFirstName(rs.getString("PassengerFirstName"));
                b2.setPassengerLastName(rs.getString("PassengerLastName"));
                b2.setDateofTravel(rs.getString("DateofTravel"));
                b2.setFlightNo(rs.getString("FlightNo"));
                b2.setOrigin(rs.getString("Origin"));
                b2.setDestination(rs.getString("Destination"));
                b2.setSeatNo(rs.getInt("SeatNo"));
                System.out.println("Search Value Found.");
                System.out.println(b2);
            }
        } catch (Exception ex5) {
            System.out.println("Error in Searching" + ex5);
        }
    }

    public void cancelBooking(String PassengerID) {
        try {
            pst = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
            pst = con.prepareStatement("Delete from passengerdetails where PassengerID=?");
            pst.setString(1, PassengerID);
            int row = pst.executeUpdate();
            if (row == 1) {
                System.out.println("Rows successfully Deleted.");
            }
        } catch (Exception ex6) {
            System.out.println("Error in Deletion" + ex6);
        }
    }

    public void updateFlightNo(String PassengerID, String updFlightNo, String Origin, String Destination) {
        try {
            pst = con.prepareStatement("UPDATE passengerdetails set FlightNo = ?, Origin = ?, Destination = ? WHERE PassengerID = ?");
            pst.setString(1, updFlightNo);
            pst.setString(2, Origin);
            pst.setString(3, Destination);
            pst.setString(4, PassengerID);
            int row = pst.executeUpdate();
            if (row == 1) {
                System.out.println("Rows Successfully update with updated Flight=" + updFlightNo + "for PassengerID =" +PassengerID);
            }
        } catch (Exception ex7) {
            System.out.println("Error in Updation" + ex7);
        }
    }

    public void updateSeatNo(String PassengerID, int updSeatNo) {
        try {
            pst = con.prepareStatement("UPDATE passengerdetails set SeatNo = ? WHERE PassengerID = ?");
            pst.setInt(1, updSeatNo);
            pst.setString(2, PassengerID);
            int row = pst.executeUpdate();
            if (row == 1) {
                System.out.println("Rows Successfully update with updated SeatNo=" + updSeatNo + "for PassengerID =" +PassengerID);
            }
        } catch (Exception ex8) {
            System.out.println("Error in Updation" + ex8);
        }
    }

    public void showBooking() {
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT passengerdetails.PassengerID,passengerdetails.PassengerFirstName,passengerdetails.PassengerLastName, passengerdetails.DateofTravel,\n" +
                    "passengerdetails.FlightNo, passengerdetails.Origin, passengerdetails.Destination, passengerdetails.SeatNo, flightdetails.Price\n" +
                    "from passengerdetails join flightdetails where passengerdetails.FlightNo=flightdetails.FlightNo");
            System.out.println("Result set successfully established.");
            while (rs.next()) {
                b1 = new BookingDetails();
                b1.setPassengerID(rs.getString("PassengerID"));
                b1.setPassengerFirstName(rs.getString("PassengerFirstName"));
                b1.setPassengerLastName(rs.getString("PassengerLastName"));
                b1.setDateofTravel(rs.getString("DateofTravel"));
                b1.setFlightNo(rs.getString("FlightNo"));
                b1.setOrigin(rs.getString("Origin"));
                b1.setDestination(rs.getString("Destination"));
                b1.setSeatNo(rs.getInt("SeatNo"));
                b1.setPrice(rs.getInt("Price"));
                System.out.println(b1);
            }
        } catch (Exception ex9) {
            System.out.println("Error in Passing SQL Statement" + ex9);
        }
    }

    /*public void addBooking(BookingDetails mybookingdetails) {
        try {
            pst = con.prepareStatement("INSERT INTO bookingdetails(PassengerID, PassengerFirstName, PassengerLastName, DateofTravel, FlightNo, Origin, Destination, Price, SeatNo) VALUES(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, mybookingdetails.getPassengerID());
            pst.setString(2, mybookingdetails.getPassengerFirstName());
            pst.setString(3, mybookingdetails.getPassengerLastName());
            pst.setString(4, mybookingdetails.getDateofTravel());
            pst.setString(5, mybookingdetails.getFlightNo());
            pst.setString(6, mybookingdetails.getOrigin());
            pst.setString(7, mybookingdetails.getDestination());
            pst.setDouble(8, mybookingdetails.getPrice());
            pst.setInt(9, mybookingdetails.getSeatNo());
            int row = pst.executeUpdate();
            if (row == 1) {
                System.out.println("Row inserted Successfully.");
            }
        } catch (Exception ex10) {
            System.out.println("Insert Error" + ex10);
        }
    }*/

    public static void main(String[] args) {
        AirlineTicketDisplay t1 = new AirlineTicketDisplay();
        AirlineTicketDisplay f1 = new AirlineTicketDisplay();
        AirlineTicketDisplay b1 = new AirlineTicketDisplay();
        int num = 0;
        Scanner sc = new Scanner(System.in);
        String choice = "Y";
        while (choice.equals("Y")) {
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Main Menu for Airline Ticket Reservation System");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("1. Add New Passenger");
            System.out.println("2. View Passenger Details");
            System.out.println("3. Add New Flight (For Admin)");
            System.out.println("4. View Flight Details");
            System.out.println("5. View Booking Details");
            System.out.println("6. Search Passenger");
            System.out.println("7. Cancel Booking");
            System.out.println("8. Update Flight No or Seat No");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Select 1 - 8 to perform any operation.");
            System.out.println("-------------------------------------------------------------------------------");
            num = sc.nextInt();
            switch (num) {
                case 1: {
                    PassengerDetails t2 = new PassengerDetails();
                    Scanner mysc = new Scanner(System.in);
                    System.out.println("Enter the PassengerID. ");
                    t2.setPassengerID(mysc.next());
                    System.out.println("Enter the First Name. ");
                    t2.setPassengerFirstName(mysc.next());
                    System.out.println("Enter the Last Name. ");
                    t2.setPassengerLastName(mysc.next());
                    System.out.println("Enter the Gender(MALE/FEMALE). ");
                    t2.setGender(mysc.next());
                    System.out.println("Enter the Mobile No. ");
                    t2.setPassengerPhoneNo(mysc.nextInt());
                    System.out.println("Enter the Email ID. ");
                    t2.setPassengerEmailID(mysc.next());
                    System.out.println("Enter the Date of Travel(DD/MM/YYYY). ");
                    t2.setDateofTravel(mysc.next());
                    f1.showFlight();
                    System.out.println("Enter the Flight No. ");
                    t2.setFlightNo(mysc.next());
                    System.out.println("Enter the Origin. ");
                    t2.setOrigin(mysc.next());
                    System.out.println("Enter the Destination. ");
                    t2.setDestination(mysc.next());
                    System.out.println("Enter the Seat No.");
                    t2.setSeatNo(mysc.nextInt());

                    t1.addPassenger(t2);
                    break;
                }
                case 2: {
                    t1.showPassenger();
                    break;
                }
                case 3: {
                    FlightDetails f2 = new FlightDetails();
                    Scanner mysc = new Scanner(System.in);
                    System.out.println("Enter the FlightNo. ");
                    f2.setFlightNo(mysc.next());
                    System.out.println("Enter the Origin. ");
                    f2.setOrigin(mysc.next());
                    System.out.println("Enter the Destination. ");
                    f2.setDestination(mysc.next());
                    System.out.println("Enter the Flight Time(HH:MM).");
                    f2.setFlightTime(mysc.next());
                    System.out.println("Enter the Type of Flight(INTERNATIONAL/DOMESTIC). ");
                    f2.setTypeofFlight(mysc.next());
                    System.out.println("Enter the No of Seats. ");
                    f2.setNoofSeats(mysc.nextInt());
                    System.out.println("Enter the Price. ");
                    f2.setPrice(mysc.nextDouble());

                    f1.addFlight(f2);
                    f1.showFlight();
                    break;
                }
                case 4: {
                    f1.showFlight();
                    break;
                }
                case 5: {
                    b1.showBooking();
                    break;
                }
                case 6: {
                    System.out.println("Enter the PassengerID to Search: ");
                    String b3 = sc.next();
                    b1.searchPassenger(b3);
                    break;
                }
                case 7: {
                    System.out.println("Enter the PassengerID to Delete: ");
                    String b2 = sc.next();
                    b1.cancelBooking(b2);
                    b1.showBooking();
                    break;
                }
                case 8: {
                    int nums = 0;
                    Scanner sc1 = new Scanner(System.in);
                    String choices = "Y";
                    while (choices.equals("Y")) {
                        System.out.println("1. Update Flight No.");
                        System.out.println("2. Change Seat No.");
                        nums = sc1.nextInt();
                        switch (nums) {
                            case 1:{
                                System.out.println("---------------------------------------------------------------");
                                System.out.println("Update Flight No.");
                                System.out.println("---------------------------------------------------------------");
                                System.out.println("Enter the PassengerID: ");
                                String PassengerID = sc.next();
                                b1.searchPassenger(PassengerID);
                                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                f1.showFlight();
                                System.out.println("Enter the FlightNo need to be updated: ");
                                String updFlightNo = sc.next();
                                System.out.println("Enter the Origin need to be updated: ");
                                String updOrigin = sc.next();
                                System.out.println("Enter the Destination need to be updated: ");
                                String updDestination = sc.next();
                                t1.updateFlightNo(PassengerID, updFlightNo, updOrigin, updDestination);
                                break;
                            }
                            case 2:{
                                System.out.println("---------------------------------------------------------------");
                                System.out.println("Change Seat No.");
                                System.out.println("---------------------------------------------------------------");
                                System.out.println("Enter the PassengerID: ");
                                String PassengerID = sc.next();
                                b1.searchPassenger(PassengerID);
                                System.out.println("Enter the SeatNo need to be updated: ");
                                int updSeatNo = sc.nextInt();
                                t1.updateSeatNo(PassengerID, updSeatNo);
                                break;
                            }
                            default:{
                                System.out.println("Invalid Choice Try Again.");
                            }
                        }
                        System.out.println("--------------------------------------------------------------------------------------------------");
                        System.out.println("Want to continue with Same Menu? Press Y if not Press other key...");
                        choices = sc1.next();
                    }
                    break;
                }
                default:{
                    System.out.println("Invalid Choice Try Again.");
                }
            }
            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.println("Want to continue with Main Menu? Press Y if not Press other key...");
            choice = sc.next();
        }
    }
}