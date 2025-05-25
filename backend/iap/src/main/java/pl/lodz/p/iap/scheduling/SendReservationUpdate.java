package pl.lodz.p.iap.scheduling;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import pl.lodz.p.iap.domain.Car;

@Service
@ConditionalOnProperty(prefix = "provider", name = "headquarters",  havingValue = "false")
public class SendReservationUpdate {
    
    @Scheduled(fixedRate = 15 * 1000)
    public void reservationUpdate() {
        RestClient defaultClient = RestClient.create();
        
        System.out.println("===============================");
        String result = defaultClient.get() 
	    .uri("http://localhost:8081/cars") 
	    .retrieve() 
	    .body(String.class); 

        System.out.println(result); 
    }
}
