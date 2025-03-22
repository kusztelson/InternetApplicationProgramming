package pl.lodz.p.iap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pl.lodz.p.iap.domain.Car;
import pl.lodz.p.iap.domain.Reservation;
import pl.lodz.p.iap.domain.RentUser;
import pl.lodz.p.iap.repository.CarRepository;
import pl.lodz.p.iap.repository.ReservationRepository;
import pl.lodz.p.iap.repository.UserRepository;

@Service
public class DataBaseServicesImpl implements CarService, UserService, ReservationService {
    private CarRepository carRepository;
    private UserRepository userRepository;
    private ReservationRepository reservationRepository;

    @Autowired
    public DataBaseServicesImpl(CarRepository carRepository, UserRepository userRepository, ReservationRepository reservationRepository) {
        this.carRepository = carRepository;
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
    }

    // CAR REPOSITORY IMPLEMENTATION

    @Transactional
    public void addCar(Car Car) {
        carRepository.save(Car);
    }

    @Transactional
    public void deleteCar(long id) {
        carRepository.deleteById(id);
    }

    @Transactional
    public void editCar(Car Car) {
        carRepository.save(Car);
    }

    @Transactional
    public Car getCar(long id) {
        return carRepository.findById(id);
    }

    @Transactional
    public List<Car> listCar() {
        return carRepository.findAll();
    }

    // USER REPOSITORY IMPLEMENTATION

    @Transactional
    public void addUser(RentUser user) {
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void editUser(RentUser user) {
        userRepository.save(user);
    }

    @Transactional
    public RentUser getUser(long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public List<RentUser> listUser() {
        return userRepository.findAll();
    }

    // RESERVATION REPOSITORY IMPLEMENTATION

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
