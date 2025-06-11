package pl.lodz.p.iap.scheduling;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import pl.lodz.p.iap.domain.Reservation;
import pl.lodz.p.iap.service.ReservationService;

@Service
@Profile("dev")
public class SendReservationUpdate {

    @Autowired ReservationService reservationService;
    @Scheduled(fixedRate = 60  * 1000)
    public void reservationUpdate() {
        RestClient defaultClient = RestClient.create();
        
        List<Reservation> to_send = reservationService.listReservation();
        
        
        System.out.println("===============================");
        try{
        String result = defaultClient.post()  // Changed to POST
                .uri("http://localhost:8081/reservations/sync")  // Changed endpoint
                .contentType(MediaType.APPLICATION_JSON)   // Set content type
                .body(to_send)                  // Send the list as JSON
                .retrieve()
                .body(String.class); 
        System.out.println(result); 
        }
        catch(Exception e){
             System.err.println("Error sending reservations to headquarters: " + e.getMessage());
        }
    }
}
