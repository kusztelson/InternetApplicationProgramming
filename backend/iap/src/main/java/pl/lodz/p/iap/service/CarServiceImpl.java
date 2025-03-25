package pl.lodz.p.iap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pl.lodz.p.iap.domain.Car;
import pl.lodz.p.iap.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

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
}
