// // .\mvnw.cmd spring-boot:run
package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dto.BookingRequest;
import com.example.demo.dto.BookingResponse;
import com.example.demo.dto.PaymentRequest;
import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;

@RestController
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping("/book")
    public BookingResponse bookTicket(@RequestBody BookingRequest request) {
        return service.createBooking(request);
    }

    @GetMapping("/bookings/{ticketId}")
    public Booking getByTicketId(@PathVariable String ticketId) {
        return service.getByTicketId(ticketId);
    }

    @PostMapping("/pay")
    public Booking pay(@RequestBody PaymentRequest request) {
        return service.saveAfterPayment(request.getTicketId());
    }
    @GetMapping("/availability")
public java.util.Map<String, Object> checkAvailability(
        @RequestParam String fromLocation,
        @RequestParam String toLocation,
        @RequestParam String travelDate) {
    return service.getAvailability(fromLocation, toLocation, travelDate);
}
}



// package com.example.demo.controller;

// import java.util.List;

// import org.springframework.web.bind.annotation.*;

// import com.example.demo.dto.BookingRequest;
// import com.example.demo.dto.BookingResponse;
// import com.example.demo.dto.PaymentRequest;
// import com.example.demo.model.Booking;
// import com.example.demo.service.BookingService;

// @RestController
// public class BookingController {

//     private final BookingService service;

//     public BookingController(BookingService service) {
//         this.service = service;
//     }

//     @PostMapping("/book")
//     public BookingResponse bookTicket(@RequestBody BookingRequest request) {
//         return service.createBooking(request);
//     }

//     @GetMapping("/bookings/{ticketId}")
//     public Booking getByTicketId(@PathVariable String ticketId) {
//         return service.getByTicketId(ticketId);
//     }

//     @PostMapping("/pay")
//     public Booking pay(@RequestBody PaymentRequest request) {
//         return service.saveAfterPayment(request.getTicketId());
//     }

//     @GetMapping("/seats")
//     public List<Integer> getBookedSeats(
//             @RequestParam String fromLocation,
//             @RequestParam String toLocation,
//             @RequestParam String travelDate) {
//         return service.getBookedSeats(fromLocation, toLocation, travelDate);
//     }
// }