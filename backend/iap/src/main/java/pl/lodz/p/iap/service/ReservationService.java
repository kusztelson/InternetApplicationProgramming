package pl.lodz.p.iap.service;

import java.util.List;

import pl.lodz.p.iap.domain.Reservation;
import pl.lodz.p.iap.domain.ReservationRequest;
import pl.lodz.p.iap.host_properties.PropertyHandler;

public interface ReservationService {
    public Reservation addReservation(ReservationRequest reservation, PropertyHandler propertyHandler);
    public void updateReservations(List<ReservationRequest> reservationList);
    public void editReservation(Reservation reservation);
    public List<Reservation> listReservation();
    public void deleteReservation(long id);
    public Reservation getReservation(long id);
    public List<Reservation> getReservationsForUser(long userId);
}
