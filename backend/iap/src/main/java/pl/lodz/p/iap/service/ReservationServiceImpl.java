package pl.lodz.p.iap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pl.lodz.p.iap.domain.Reservation;
import pl.lodz.p.iap.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Transactional
    public void addReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Transactional
    public void deleteReservation(long id) {
        reservationRepository.deleteById(id);
    }

    @Transactional
    public void editReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Transactional
    public Reservation getReservation(long id) {
        return reservationRepository.findById(id);
    }

    @Transactional
    public List<Reservation> listReservation() {
        return reservationRepository.findAll();
    }
    
}
