package pl.lodz.p.iap.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lodz.p.iap.domain.Reservation;
import pl.lodz.p.iap.repository.ReservationRepository;

import java.util.List;


@RestController
@RequestMapping("/reservations")
public class ReservationSyncController {

    private final ReservationRepository reservationRepository;

    public ReservationSyncController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @PostMapping("/sync")
    public ResponseEntity<String> syncReservations(@RequestBody List<Reservation> incomingReservations) {
        try {
        reservationRepository.deleteAll();

        reservationRepository.saveAll(incomingReservations); // Save new ones
            return ResponseEntity.ok("Reservations synced successfully.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to sync reservations: " + e.getMessage());
        }
    }
}



