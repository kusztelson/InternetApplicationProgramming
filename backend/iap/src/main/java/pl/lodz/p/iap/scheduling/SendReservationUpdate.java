package pl.lodz.p.iap.scheduling;

import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@Profile("dev")
public class SendReservationUpdate {
    
    @Scheduled(fixedRate = 15 * 1000)
    public void reservationUpdate() {
        RestClient defaultClient = RestClient.create();
        
        System.out.println("===============================");
        //String result = defaultClient.get() 
	    //.uri("http://localhost:8081/cars") 
	    //.retrieve() 
	    //.body(String.class); 

        //System.out.println(result); 
    }
}
