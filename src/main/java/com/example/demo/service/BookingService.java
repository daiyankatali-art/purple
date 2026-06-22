// package com.example.demo.service;

// import java.util.UUID;
// import org.springframework.http.HttpStatus;
// import org.springframework.stereotype.Service;
// import org.springframework.web.server.ResponseStatusException;
// import java.util.Optional;
// import com.example.demo.dto.BookingRequest;
// import com.example.demo.dto.BookingResponse;
// import com.example.demo.model.Booking;
// import com.example.demo.repository.BookingRepository;

// @Service
// public class BookingService {

//     private final BookingRepository repository;

//     public BookingService(BookingRepository repository) {
//         this.repository = repository;
//     }

//     public BookingResponse createBooking(BookingRequest request) {

//         if (request.getTickets() <= 0) {
//             throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tickets must be at least 1");
//         }
//               Optional<Booking> existing = repository.findByNameAndFromLocationAndToLocationAndTravelDate(
//                 request.getName(),
//                 request.getFromLocation(),
//                 request.getToLocation(),
//                 request.getTravelDate()
//         );

//         if (existing.isPresent()) {
//             Booking booking = existing.get();
//             String message = "PAID".equals(booking.getMessage())
//                     ? "You already booked and paid for this trip."
//                     : "You already have a pending booking for this trip. Proceed to payment.";
//             return new BookingResponse(booking.getTicketId(), booking.getAmount(), message);
//         }

//        double pricePerTicket = 0;

//     if (
//         (request.getFromLocation().toUpperCase().equals("ACCRA")
//             && request.getToLocation().toUpperCase().equals("CAPE COAST"))
//         ||
//         (request.getFromLocation().toUpperCase().equals("CAPE COAST")
//             && request.getToLocation().toUpperCase().equals("ACCRA"))
//     ) {
//         pricePerTicket = 115;
//     }
//     else if((request.getFromLocation().toUpperCase().equals("ACCRA")
//             && request.getToLocation().toUpperCase().equals("KUMASI"))
//         ||
//         (request.getFromLocation().toUpperCase().equals("KUMASI")
//             && request.getToLocation().toUpperCase().equals("ACCRA"))
//         ){
//         pricePerTicket = 120;
//             }
//          else if((request.getFromLocation().toUpperCase().equals("ACCRA")
//             && request.getToLocation().toUpperCase().equals("TAMALE"))
//         ||
//         (request.getFromLocation().toUpperCase().equals("TAMALE")
//             && request.getToLocation().toUpperCase().equals("ACCRA"))
//         ){
//         pricePerTicket = 200;
//             }
//          else if((request.getFromLocation().toUpperCase().equals("CAPE COAST")
//             && request.getToLocation().toUpperCase().equals("TAMALE"))
//         ||
//         (request.getFromLocation().toUpperCase().equals("TAMALE")
//             && request.getToLocation().toUpperCase().equals("CAPE COAST"))
//         ){
//         pricePerTicket = 220;
//             }
//          else if((request.getFromLocation().toUpperCase().equals("ACCRA")
//             && request.getToLocation().toUpperCase().equals("TAKORADI"))
//         ||
//         (request.getFromLocation().toUpperCase().equals("TAKORADI")
//             && request.getToLocation().toUpperCase().equals("ACCRA"))
//         ){
//         pricePerTicket = 120;
//             }
//          else if((request.getFromLocation().toUpperCase().equals("CAPE COAST")
//             && request.getToLocation().toUpperCase().equals("TAKORADI"))
//         ||
//         (request.getFromLocation().toUpperCase().equals("TAKORADI")
//             && request.getToLocation().toUpperCase().equals("CAPE COAST"))
//         ){
//         pricePerTicket = 80;
//             }
//          else if((request.getFromLocation().toUpperCase().equals("CAPE COAST")
//             && request.getToLocation().toUpperCase().equals("BOLGATANGA"))
//         ||
//         (request.getFromLocation().toUpperCase().equals("BOLGATANGA")
//             && request.getToLocation().toUpperCase().equals("CAPE COAST"))
//         ){
//         pricePerTicket = 300;
//             }
//          else if((request.getFromLocation().toUpperCase().equals("TAKORADI")
//             && request.getToLocation().toUpperCase().equals("TAMALE"))
//         ||
//         (request.getFromLocation().toUpperCase().equals("TAMALE")
//             && request.getToLocation().toUpperCase().equals("TAKORADI"))
//         ){
//         pricePerTicket = 390;
//             }
//          else if((request.getFromLocation().toUpperCase().equals("ACCRA")
//             && request.getToLocation().toUpperCase().equals("BOLGATANGA"))
//         ||
//         (request.getFromLocation().toUpperCase().equals("BOLGATANGA")
//             && request.getToLocation().toUpperCase().equals("ACCRA"))
//         ){
//         pricePerTicket = 300;
//             }
//          else if((request.getFromLocation().toUpperCase().equals("KUMASI")
//             && request.getToLocation().toUpperCase().equals("TAMALE"))
//         ||
//         (request.getFromLocation().toUpperCase().equals("TAMALE")
//             && request.getToLocation().toUpperCase().equals("KUMASI"))
//         ){
//         pricePerTicket = 120;
//             }

//          else if((request.getFromLocation().toUpperCase().equals("TAKORADI")
//             && request.getToLocation().toUpperCase().equals("KUMASI"))
//         ||
//         (request.getFromLocation().toUpperCase().equals("KUMASI")
//             && request.getToLocation().toUpperCase().equals("TAKORADI"))
//         ){
//         pricePerTicket = 130;
//             }
//          else if((request.getFromLocation().toUpperCase().equals("CAPE COAST")
//             && request.getToLocation().toUpperCase().equals("KUMASI"))
//         ||
//         (request.getFromLocation().toUpperCase().equals("KUMASI")
//             && request.getToLocation().toUpperCase().equals("CAPE COAST"))
//         ){
//         pricePerTicket = 115;
//             }
//          else if((request.getFromLocation().toUpperCase().equals("BOLGATANGA")
//             && request.getToLocation().toUpperCase().equals("KUMASI"))
//         ||
//         (request.getFromLocation().toUpperCase().equals("KUMASI")
//             && request.getToLocation().toUpperCase().equals("BOLGATANGA"))
//         ){
//         pricePerTicket = 125;
//             }
//          else if((request.getFromLocation().toUpperCase().equals("BOLGATANGA")
//             && request.getToLocation().toUpperCase().equals("KUMASI"))
//         ||
//         (request.getFromLocation().toUpperCase().equals("KUMASI")
//             && request.getToLocation().toUpperCase().equals("BOLGATANGA"))
//         ){
//         pricePerTicket = 120;
//             }
   
//          else if((request.getFromLocation().toUpperCase().equals("TAKORADI")
//             && request.getToLocation().toUpperCase().equals("BOLGATANGA"))
//         ||
//         (request.getFromLocation().toUpperCase().equals("BOLGATANGA")
//             && request.getToLocation().toUpperCase().equals("TAKORADI"))
//         ){
//         pricePerTicket = 320;
//             }

//          else if((request.getFromLocation().toUpperCase().equals("TAMALE")
//             && request.getToLocation().toUpperCase().equals("BOLGATANGA"))
//         ||
//         (request.getFromLocation().toUpperCase().equals("BOLGATANGA")
//             && request.getToLocation().toUpperCase().equals("TAMALE"))
//         ){
//         pricePerTicket = 120;
//             }

        





//         double amount = request.getTickets() * pricePerTicket;

//         String ticketId = "PTS-" +
//                 UUID.randomUUID().toString().substring(0, 8).toUpperCase();

//         Booking booking = new Booking();
//         booking.setTicketId(ticketId);
//         booking.setName(request.getName());
//         booking.setFromLocation(request.getFromLocation());
//         booking.setToLocation(request.getToLocation());
//         booking.setTravelDate(request.getTravelDate());
//         booking.setTickets(request.getTickets());
//         booking.setAmount(amount);
//         booking.setMessage("PENDING");

//         repository.save(booking);

//         return new BookingResponse(ticketId, amount, "Proceed to payment");
//     }

//     public Booking getByTicketId(String ticketId) {
//         return repository.findByTicketId(ticketId)
//                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found"));
//     }

//     public Booking saveAfterPayment(String ticketId) {
//         Booking booking = repository.findByTicketId(ticketId)
//                 .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found"));

//         booking.setMessage("PAID");
//         return repository.save(booking);
//     }
// }








package com.example.demo.service;

import java.util.UUID;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;
import com.example.demo.dto.BookingRequest;
import com.example.demo.dto.BookingResponse;
import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;

@Service
public class BookingService {

    private static final int BUS_CAPACITY = 10; // seats per bus, per route+date

    private final BookingRepository repository;

    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }

    public BookingResponse createBooking(BookingRequest request) {

        if (request.getTickets() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tickets must be at least 1");
        }
                LocalDate travelDate;
        try {
            travelDate = LocalDate.parse(request.getTravelDate());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date format");
        }

        LocalDate today = LocalDate.now();
        LocalDate maxDate = today.plusDays(7);

        if (travelDate.isBefore(today) || travelDate.isAfter(maxDate)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "You can only book a trip from today up to 7 days ahead.");
        }

        Optional<Booking> existing = repository.findByNameAndFromLocationAndToLocationAndTravelDate(
                request.getName(),
                request.getFromLocation(),
                request.getToLocation(),
                request.getTravelDate()
        );

        if (existing.isPresent()) {
            Booking booking = existing.get();
            String message = "PAID".equals(booking.getMessage())
                    ? "You already booked and paid for this trip."
                    : "You already have a pending booking for this trip. Proceed to payment.";
            return new BookingResponse(booking.getTicketId(), booking.getAmount(), message);
        }

        // CAPACITY CHECK — how many seats already taken for this exact route + date?
        int alreadyBooked = repository.sumTicketsForTrip(
                request.getFromLocation(), request.getToLocation(), request.getTravelDate());
        int seatsLeft = BUS_CAPACITY - alreadyBooked;

        if (seatsLeft <= 0) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Sorry, the bus for this route and date is fully booked.");
        }

        if (request.getTickets() > seatsLeft) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Only " + seatsLeft + " seat(s) left for this trip. Please reduce your ticket count.");
        }

        double pricePerTicket = 0;

        if (
            (request.getFromLocation().toUpperCase().equals("ACCRA")
                && request.getToLocation().toUpperCase().equals("CAPE COAST"))
            ||
            (request.getFromLocation().toUpperCase().equals("CAPE COAST")
                && request.getToLocation().toUpperCase().equals("ACCRA"))
        ) {
            pricePerTicket = 115;
        }
        else if((request.getFromLocation().toUpperCase().equals("ACCRA")
                && request.getToLocation().toUpperCase().equals("KUMASI"))
            ||
            (request.getFromLocation().toUpperCase().equals("KUMASI")
                && request.getToLocation().toUpperCase().equals("ACCRA"))
            ){
            pricePerTicket = 120;
                }
             else if((request.getFromLocation().toUpperCase().equals("ACCRA")
                && request.getToLocation().toUpperCase().equals("TAMALE"))
            ||
            (request.getFromLocation().toUpperCase().equals("TAMALE")
                && request.getToLocation().toUpperCase().equals("ACCRA"))
            ){
            pricePerTicket = 200;
                }
             else if((request.getFromLocation().toUpperCase().equals("CAPE COAST")
                && request.getToLocation().toUpperCase().equals("TAMALE"))
            ||
            (request.getFromLocation().toUpperCase().equals("TAMALE")
                && request.getToLocation().toUpperCase().equals("CAPE COAST"))
            ){
            pricePerTicket = 220;
                }
             else if((request.getFromLocation().toUpperCase().equals("ACCRA")
                && request.getToLocation().toUpperCase().equals("TAKORADI"))
            ||
            (request.getFromLocation().toUpperCase().equals("TAKORADI")
                && request.getToLocation().toUpperCase().equals("ACCRA"))
            ){
            pricePerTicket = 120;
                }
             else if((request.getFromLocation().toUpperCase().equals("CAPE COAST")
                && request.getToLocation().toUpperCase().equals("TAKORADI"))
            ||
            (request.getFromLocation().toUpperCase().equals("TAKORADI")
                && request.getToLocation().toUpperCase().equals("CAPE COAST"))
            ){
            pricePerTicket = 80;
                }
             else if((request.getFromLocation().toUpperCase().equals("CAPE COAST")
                && request.getToLocation().toUpperCase().equals("BOLGATANGA"))
            ||
            (request.getFromLocation().toUpperCase().equals("BOLGATANGA")
                && request.getToLocation().toUpperCase().equals("CAPE COAST"))
            ){
            pricePerTicket = 300;
                }
             else if((request.getFromLocation().toUpperCase().equals("TAKORADI")
                && request.getToLocation().toUpperCase().equals("TAMALE"))
            ||
            (request.getFromLocation().toUpperCase().equals("TAMALE")
                && request.getToLocation().toUpperCase().equals("TAKORADI"))
            ){
            pricePerTicket = 390;
                }
             else if((request.getFromLocation().toUpperCase().equals("ACCRA")
                && request.getToLocation().toUpperCase().equals("BOLGATANGA"))
            ||
            (request.getFromLocation().toUpperCase().equals("BOLGATANGA")
                && request.getToLocation().toUpperCase().equals("ACCRA"))
            ){
            pricePerTicket = 300;
                }
             else if((request.getFromLocation().toUpperCase().equals("KUMASI")
                && request.getToLocation().toUpperCase().equals("TAMALE"))
            ||
            (request.getFromLocation().toUpperCase().equals("TAMALE")
                && request.getToLocation().toUpperCase().equals("KUMASI"))
            ){
            pricePerTicket = 120;
                }

             else if((request.getFromLocation().toUpperCase().equals("TAKORADI")
                && request.getToLocation().toUpperCase().equals("KUMASI"))
            ||
            (request.getFromLocation().toUpperCase().equals("KUMASI")
                && request.getToLocation().toUpperCase().equals("TAKORADI"))
            ){
            pricePerTicket = 130;
                }
             else if((request.getFromLocation().toUpperCase().equals("CAPE COAST")
                && request.getToLocation().toUpperCase().equals("KUMASI"))
            ||
            (request.getFromLocation().toUpperCase().equals("KUMASI")
                && request.getToLocation().toUpperCase().equals("CAPE COAST"))
            ){
            pricePerTicket = 115;
                }
             else if((request.getFromLocation().toUpperCase().equals("BOLGATANGA")
                && request.getToLocation().toUpperCase().equals("KUMASI"))
            ||
            (request.getFromLocation().toUpperCase().equals("KUMASI")
                && request.getToLocation().toUpperCase().equals("BOLGATANGA"))
            ){
            pricePerTicket = 125;
                }
             else if((request.getFromLocation().toUpperCase().equals("BOLGATANGA")
                && request.getToLocation().toUpperCase().equals("KUMASI"))
            ||
            (request.getFromLocation().toUpperCase().equals("KUMASI")
                && request.getToLocation().toUpperCase().equals("BOLGATANGA"))
            ){
            pricePerTicket = 120;
                }

             else if((request.getFromLocation().toUpperCase().equals("TAKORADI")
                && request.getToLocation().toUpperCase().equals("BOLGATANGA"))
            ||
            (request.getFromLocation().toUpperCase().equals("BOLGATANGA")
                && request.getToLocation().toUpperCase().equals("TAKORADI"))
            ){
            pricePerTicket = 320;
                }

             else if((request.getFromLocation().toUpperCase().equals("TAMALE")
                && request.getToLocation().toUpperCase().equals("BOLGATANGA"))
            ||
            (request.getFromLocation().toUpperCase().equals("BOLGATANGA")
                && request.getToLocation().toUpperCase().equals("TAMALE"))
            ){
            pricePerTicket = 120;
                }

        double amount = request.getTickets() * pricePerTicket;

        String ticketId = "PTS-" +
                UUID.randomUUID().toString().substring(0, 8).toUpperCase();

        Booking booking = new Booking();
        booking.setTicketId(ticketId);
        booking.setName(request.getName());
        booking.setFromLocation(request.getFromLocation());
        booking.setToLocation(request.getToLocation());
        booking.setTravelDate(request.getTravelDate());
        booking.setTickets(request.getTickets());
        booking.setAmount(amount);
        booking.setMessage("PENDING");

        repository.save(booking);

        return new BookingResponse(ticketId, amount, "Proceed to payment");
    }

    public Booking getByTicketId(String ticketId) {
        return repository.findByTicketId(ticketId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found"));
    }

    public Booking saveAfterPayment(String ticketId) {
        Booking booking = repository.findByTicketId(ticketId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found"));

        booking.setMessage("PAID");
        return repository.save(booking);
    }

public Map<String, Object> getAvailability(String fromLocation, String toLocation, String travelDate) {
    int booked = repository.sumTicketsForTrip(fromLocation, toLocation, travelDate);
    int seatsLeft = Math.max(BUS_CAPACITY - booked, 0);

    Map<String, Object> result = new HashMap<>();
    result.put("capacity", BUS_CAPACITY);
    result.put("booked", booked);
    result.put("seatsLeft", seatsLeft);
    return result;
}
}


