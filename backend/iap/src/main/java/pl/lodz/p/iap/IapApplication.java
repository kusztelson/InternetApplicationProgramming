package pl.lodz.p.iap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IapApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(IapApplication.class);
		app.run(args);
	}
}
