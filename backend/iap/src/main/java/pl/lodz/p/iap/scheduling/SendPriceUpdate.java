package pl.lodz.p.iap.scheduling;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(prefix = "provider", name = "headquarters", havingValue = "true")
public class SendPriceUpdate {
    
    @Scheduled(fixedRate = 15 * 1000)
    public void priceUpdate() {
        System.out.println("Wysłano update cen do oddziałów");
    }
}
