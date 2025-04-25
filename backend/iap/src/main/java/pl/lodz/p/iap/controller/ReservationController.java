package pl.lodz.p.iap.controller;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.lodz.p.iap.domain.Reservation;
import pl.lodz.p.iap.domain.ReservationRequest;
import pl.lodz.p.iap.exceptions.ReservationNotFoundException;
import pl.lodz.p.iap.service.ReservationService;

@RestController
public class ReservationController {
    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(value = "/reservation/{reservationId}")
    public Reservation showReservation(HttpServletRequest request, @PathVariable("reservationId") Long reservationId) {
        Reservation foundReservation = null;
        foundReservation = reservationService.getReservation(reservationId);

        if(foundReservation == null)
        {
            throw new ReservationNotFoundException(reservationId, "/reservation/%d".formatted(reservationId));
        }

        return foundReservation;
    }

    @RequestMapping(value = "/reservations")
    public List<Reservation> showReservations(HttpServletRequest request) {
        List<Reservation> ReservationList = reservationService.listReservation();
        return ReservationList;
    }

    @RequestMapping(value = "/addReservation", method = RequestMethod.POST)
    public Reservation addReservation(@RequestBody ReservationRequest reservation) {        
        var newReservation = reservationService.addReservation(reservation);
        return newReservation;
    }

    @RequestMapping(value = "/reservations/delete/{reservationId}")
    public void deleteReservation(@PathVariable("reservationId") Long reservationId) {
        reservationService.deleteReservation(reservationId);
    }
}
