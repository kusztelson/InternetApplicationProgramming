package pl.lodz.p.iap.controller;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.lodz.p.iap.domain.Reservation;
import pl.lodz.p.iap.service.ReservationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
        return foundReservation;
    }

    @RequestMapping(value = "/reservations")
    public List<Reservation> showReservations(HttpServletRequest request) {
        List<Reservation> ReservationList = reservationService.listReservation();
        return ReservationList;
    }

    @RequestMapping(value = "/addReservation", method = RequestMethod.POST)
    public Object addReservation(@ModelAttribute("reservation") Reservation reservation) {
        System.out.println("Car: " + reservation.getCarId() +
                " User: " + reservation.getUserId() + " Start date: " + reservation.getStartDate() +
                " End date: " + reservation.getEndDate()) ;

        try
        {
            if (reservation.getId() == 0)
            {
                reservationService.addReservation(reservation);
            }
            else
            {
                reservationService.editReservation(reservation);
            }
        }
        catch(Exception e)
        {
            return new ResponseEntity<Void>(HttpStatusCode.valueOf(404));
        }

        return reservation;
    }

    @RequestMapping(value = "/reservations/delete/{reservationId}")
    public void deleteReservation(@PathVariable("reservationId") Long reservationId) {
        reservationService.deleteReservation(reservationId);
        //return "redirect:/reservations";
    }
}
