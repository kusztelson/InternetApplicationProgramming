package pl.lodz.p.iap.service;

import java.util.List;

import pl.lodz.p.iap.domain.Car;

public interface CarService {
    public void addCar(Car Car);
    public void editCar(Car Car);
    public List<Car> listCar();
    public void deleteCar(long id);
    public Car getCar(long id);
}
