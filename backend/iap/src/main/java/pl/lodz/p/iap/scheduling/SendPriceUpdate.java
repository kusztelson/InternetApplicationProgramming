package pl.lodz.p.iap.scheduling;

import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Profile("host")
public class SendPriceUpdate {
    
    @Scheduled(fixedRate = 15 * 1000)
    public void priceUpdate() {
        System.out.println("Wysłano update cen do oddziałów");
    }
}
