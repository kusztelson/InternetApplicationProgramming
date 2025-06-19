package pl.lodz.p.iap.scheduling;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import pl.lodz.p.iap.domain.Car;
import pl.lodz.p.iap.service.CarService;

@Service
@Profile("host")
public class SendPriceUpdate {
    
    @Autowired CarService carService;
    @Scheduled(fixedRate = 60  * 1000)
    public void priceUpdate() {
        RestClient defaultClient = RestClient.create();
        
        List<Car> cars_to_send = carService.listCar();
        
        
        System.out.println("===============================");
        try{
        String result = defaultClient.post()  // Changed to POST
                .uri("http://localhost:8080/car/sync")  // Changed endpoint
                .contentType(MediaType.APPLICATION_JSON)   // Set content type
                .body(cars_to_send)                  // Send the list as JSON
                .retrieve()
                .body(String.class); 
        System.out.println(result); 
        }
        catch(Exception e){
             System.err.println("Error sending cars to branches: " + e.getMessage());
        }
    }
}
