
package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Booking;


public interface BookingRepository extends JpaRepository<Booking, Long> {

    Optional<Booking> findByTicketId(String ticketId);

    Optional<Booking> findByNameAndFromLocationAndToLocationAndTravelDate(
            String name, String fromLocation, String toLocation, String travelDate);

            
    @Query("SELECT COALESCE(SUM(b.tickets), 0) FROM Booking b " +
           "WHERE b.fromLocation = :fromLocation AND b.toLocation = :toLocation AND b.travelDate = :travelDate")
    int sumTicketsForTrip(@Param("fromLocation") String fromLocation,
                           @Param("toLocation") String toLocation,
                           @Param("travelDate") String travelDate);
}



// package com.example.demo.repository;

// import java.util.List;
// import java.util.Optional;
// import org.springframework.data.jpa.repository.JpaRepository;

// import com.example.demo.model.Booking;

// public interface BookingRepository extends JpaRepository<Booking, Long> {

//     Optional<Booking> findByTicketId(String ticketId);

//     List<Booking> findByFromLocationAndToLocationAndTravelDate(
//             String fromLocation, String toLocation, String travelDate);
// }