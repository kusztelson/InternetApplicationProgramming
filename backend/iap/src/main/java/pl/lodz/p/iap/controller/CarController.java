package pl.lodz.p.iap.controller;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.lodz.p.iap.domain.Car;
import pl.lodz.p.iap.exceptions.CarNotFoundException;
import pl.lodz.p.iap.service.CarService;


@RestController
public class CarController {
    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/car/{carId}")
    public Car showCar(@PathVariable("carId") Long carId) {
        Car foundCar = null;
        foundCar = carService.getCar(carId);
        
        if(foundCar == null)
        {
            throw new CarNotFoundException(carId, "/car/%d".formatted(carId));
        }

        return foundCar;
    }

    @RequestMapping(value = "/cars")
    public List<Car> showCars(HttpServletRequest request) {
        List<Car> CarList = carService.listCar();
        return CarList;
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public Object addCar(@ModelAttribute("car") Car car) {
        System.out.println("Name: " + car.getName() +
                " Picture: " + car.getPicture() + " Price: " + car.getPricePerDay());
        
        try
        {
            if (car.getId() == 0)
            {
                carService.addCar(car);
            }
            else
            {
                carService.editCar(car);
            }
        }
        catch(Exception e)
        {
            Long carId = car.getId();
            throw new CarNotFoundException(carId, "/addCar");
        }

        return car;
    }

    @RequestMapping(value = "/cars/delete/{carId}")
    public void deleteUser(@PathVariable("carId") Long carId) {
        carService.deleteCar(carId);
    }

    @RequestMapping(value = "/cars/edit/{carId}", method = RequestMethod.GET)
    public Car showEditedCar(@PathVariable("carId") Long carId) {
        return showCar(carId);
    }

    @RequestMapping(value = "/cars/edit/{carId}", method = RequestMethod.PUT)
    public Car saveCarEditChanges(@RequestBody Car car) {
        try
        {
            carService.editCar(car);
        }
        catch(Exception e)
        {
            Long carId = car.getId();
            throw new CarNotFoundException(carId, "/cars/edit/%d".formatted(carId));
        }

        return car;
    }
    
}
