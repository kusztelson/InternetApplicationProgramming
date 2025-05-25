package pl.lodz.p.iap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pl.lodz.p.iap.domain.Reservation;
import pl.lodz.p.iap.domain.ReservationRequest;
import pl.lodz.p.iap.repository.CarRepository;
import pl.lodz.p.iap.repository.ReservationRepository;
import pl.lodz.p.iap.repository.UserRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepository reservationRepository;
    private CarRepository carRepository;
    private UserRepository userRepository;

    @Autowired
    public ReservationServiceImpl(
            ReservationRepository reservationRepository,
            CarRepository carRepository,
            UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Reservation addReservation(ReservationRequest reservation) {
        var car = carRepository.findById(reservation.getCarId());
        var user = userRepository.findById(reservation.getUserId());
        return reservationRepository.save(new Reservation(0, car, user, reservation.getStartDate(), reservation.getEndDate()));
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

    @Override
    public List<Reservation> getReservationsForUser(long userId) {
        return reservationRepository.findByUserId(userRepository.findById(userId));
    }

    @Transactional
    public void updateReservations(List<ReservationRequest> reservationList) {
        List<Reservation> presentReservations = reservationRepository.findAll();

        for(ReservationRequest r : reservationList)
            System.out.println(r);
    }
}
