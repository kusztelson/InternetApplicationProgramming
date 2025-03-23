package pl.lodz.p.iap.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
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

    @RequestMapping(value = "/reservations")
    public String showReservations(Model model, HttpServletRequest request) {
        int reservationId = ServletRequestUtils.getIntParameter(request, "reservationId", -1);

        if (reservationId > 0) {
            model.addAttribute("reservation", reservationService.getReservation(reservationId));
        }
        else
        {
            model.addAttribute("reservation", new Reservation());
        }
        model.addAttribute("reservationList", reservationService.listReservation());

        return "reservation";
    }

    @RequestMapping(value = "/addReservation", method = RequestMethod.POST)
    public String addReservation(@ModelAttribute("reservation") Reservation reservation) {
        System.out.println("Car: " + reservation.getCarId() +
                " User: " + reservation.getUserId() + " Start date: " + reservation.getStartDate() +
                " End date: " + reservation.getEndDate()) ;

                String message = "redirect:reservations";
        
                if (reservation.getId() == 0)
                {
                    try
                    {
                        reservationService.addReservation(reservation);
                    }
                    catch(Exception e)
                    {
                        message = e.getMessage();
                    }
                }
                else
                {
                    try
                    {
                        reservationService.editReservation(reservation);
                    }
                    catch(Exception e)
                    {
                        message = e.getMessage();
                    }
                }
        
                return message;
    }

    @RequestMapping(value = "/reservations/delete/{reservationId}")
    public String deleteReservation(@PathVariable("reservationId") Long reservationId) {
        reservationService.deleteReservation(reservationId);
        return "redirect:/reservations";
    }
}
