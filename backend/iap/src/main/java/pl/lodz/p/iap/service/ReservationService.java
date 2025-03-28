package pl.lodz.p.iap.service;

import java.util.List;

import pl.lodz.p.iap.domain.Reservation;

public interface ReservationService {
    public void addReservation(Reservation reservation);
    public void editReservation(Reservation reservation);
    public List<Reservation> listReservation();
    public void deleteReservation(long id);
    public Reservation getReservation(long id);
}
