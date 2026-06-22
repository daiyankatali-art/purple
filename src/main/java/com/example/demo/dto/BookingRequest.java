package com.example.demo.dto;

public class BookingRequest {

    private String name;
    private String fromLocation;
    private String toLocation;
    private String travelDate;
    private int tickets;

    public BookingRequest() {
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
}



// package com.example.demo.dto;

// import java.util.List;

// public class BookingRequest {

//     private String name;
//     private String fromLocation;
//     private String toLocation;
//     private String travelDate;
//     private List<Integer> seatNumbers;

//     public BookingRequest() {}

//     public String getName() { return name; }
//     public void setName(String name) { this.name = name; }
//     public String getFromLocation() { return fromLocation; }
//     public void setFromLocation(String fromLocation) { this.fromLocation = fromLocation; }
//     public String getToLocation() { return toLocation; }
//     public void setToLocation(String toLocation) { this.toLocation = toLocation; }
//     public String getTravelDate() { return travelDate; }
//     public void setTravelDate(String travelDate) { this.travelDate = travelDate; }
//     public List<Integer> getSeatNumbers() { return seatNumbers; }
//     public void setSeatNumbers(List<Integer> seatNumbers) { this.seatNumbers = seatNumbers; }
// }