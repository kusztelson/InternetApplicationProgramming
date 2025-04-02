package pl.lodz.p.iap.exceptions;

public class ReservationNotFoundException extends ItemNotFoundException {

    public ReservationNotFoundException(Long id, String path) {
        super("Reservation with id %d not found".formatted(id), path, "Reservation not found");
    }
}
