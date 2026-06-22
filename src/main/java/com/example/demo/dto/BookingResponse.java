

package com.example.demo.dto;

public class BookingResponse {

    private String ticketId;
    private double amount;
    private String message;

    public BookingResponse(String ticketId, double amount, String message) {
        this.ticketId = ticketId;
        this.amount = amount;
        this.message = message;
    }

    public String getTicketId() {
        return ticketId;
    }

    public double getAmount() {
        return amount;
    }

    public String getMessage() {
        return message;
    }
}