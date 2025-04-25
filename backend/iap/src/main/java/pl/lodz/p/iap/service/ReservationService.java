package pl.lodz.p.iap.service;

import java.util.List;

import pl.lodz.p.iap.domain.Reservation;
import pl.lodz.p.iap.domain.ReservationRequest;

public interface ReservationService {
    public Reservation addReservation(ReservationRequest reservation);
    public void editReservation(Reservation reservation);
    public List<Reservation> listReservation();
    public void deleteReservation(long id);
    public Reservation getReservation(long id);
    public List<Reservation> getReservationsForUser(long userId);
}
