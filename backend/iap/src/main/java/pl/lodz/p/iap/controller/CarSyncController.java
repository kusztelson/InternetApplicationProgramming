package pl.lodz.p.iap.controller;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lodz.p.iap.domain.Car;
import pl.lodz.p.iap.repository.CarRepository;



@RestController
@RequestMapping("/car")
public class CarSyncController {

    @Autowired
    CarRepository carRepository;
    
    @PostMapping("/update")
    public ResponseEntity<String> updateCarPrices(@RequestBody List<Car> priceUpdates) {
        try {
        for (Car incoming : priceUpdates) {
            Long carId = incoming.getId();
            Float newPrice = incoming.getPricePerDay();

            Optional<Car> carOpt = carRepository.findById(carId);
            if (carOpt.isPresent()) {
                Car car = carOpt.get();
                car.setPricePerDay(newPrice);
                carRepository.save(car);
            }
        }
        return ResponseEntity.ok("Car prices updated successfully.");
       } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to sync cars: " + e.getMessage());
        }
    }
}