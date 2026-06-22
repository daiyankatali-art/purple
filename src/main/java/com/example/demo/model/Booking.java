package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ticketId;

    private String name;

    @Column(name = "from_location")
    private String fromLocation;

    @Column(name = "to_location")
    private String toLocation   ;

    private String travelDate;

    private int tickets;

    private double amount;

    private String message;

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public String getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}




// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// @Table(name = "bookings")
// public class Booking {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String ticketId;
//     private String name;

//     @Column(name = "from_location")
//     private String fromLocation;

//     @Column(name = "to_location")
//     private String toLocation;

//     private String travelDate;
//     private int tickets;
//     private double amount;
//     private String message;

//     @Column(name = "seat_numbers")
//     private String seatNumbers; // comma-separated, e.g. "3,4,12"

//     public Booking() {}

//     public Long getId() { return id; }
//     public String getTicketId() { return ticketId; }
//     public void setTicketId(String ticketId) { this.ticketId = ticketId; }
//     public String getName() { return name; }
//     public void setName(String name) { this.name = name; }
//     public String getFromLocation() { return fromLocation; }
//     public void setFromLocation(String fromLocation) { this.fromLocation = fromLocation; }
//     public String getToLocation() { return toLocation; }
//     public void setToLocation(String toLocation) { this.toLocation = toLocation; }
//     public String getTravelDate() { return travelDate; }
//     public void setTravelDate(String travelDate) { this.travelDate = travelDate; }
//     public int getTickets() { return tickets; }
//     public void setTickets(int tickets) { this.tickets = tickets; }
//     public double getAmount() { return amount; }
//     public void setAmount(double amount) { this.amount = amount; }
//     public String getMessage() { return message; }
//     public void setMessage(String message) { this.message = message; }
//     public String getSeatNumbers() { return seatNumbers; }
//     public void setSeatNumbers(String seatNumbers) { this.seatNumbers = seatNumbers; }
// }