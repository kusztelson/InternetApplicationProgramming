package pl.lodz.p.iap.host_properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("host")
@ConfigurationProperties(prefix = "contact")
public class HeadquaterProperties extends PropertyHandler {

    public HeadquaterProperties() {

    }
}
