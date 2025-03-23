package pl.lodz.p.iap.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.lodz.p.iap.domain.Car;
import pl.lodz.p.iap.service.CarService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CarController {
    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/cars")
    public String showCars(Model model, HttpServletRequest request) {
        int userId = ServletRequestUtils.getIntParameter(request, "carId", -1);

        if (userId > 0) {
            model.addAttribute("car", carService.getCar(userId));
        }
        else
        {
            model.addAttribute("car", new Car());
        }
        model.addAttribute("carList", carService.listCar());

        return "car";
    }

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public String addCar(@ModelAttribute("car") Car car) {
        System.out.println("Name: " + car.getName() +
                " Picture: " + car.getPicture() + " Price: " + car.getPricePerDay());

                String message = "redirect:cars";
        
                if (car.getId() == 0)
                {
                    try
                    {
                        carService.addCar(car);
                    }
                    catch(Exception e)
                    {
                        message = e.getMessage();
                    }
                }
                else
                {
                    try
                    {
                        carService.editCar(car);
                    }
                    catch(Exception e)
                    {
                        message = e.getMessage();
                    }
                }
        
                return message;
    }

    @RequestMapping(value = "/cars/delete/{carId}")
    public String deleteUser(@PathVariable("carId") Long carId) {
        carService.deleteCar(carId);
        return "redirect:/cars";
    }
}
