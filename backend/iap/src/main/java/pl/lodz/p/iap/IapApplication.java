package pl.lodz.p.iap;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IapApplication {

	//@Value("${provider.headquarters}")
	private static boolean isHeadquarters = false;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(IapApplication.class);

		Map<String, Object> properties = new HashMap<>();

		if(isHeadquarters) {
			// Host config
			properties.put("server.port", "8081");
		}
		else {
			// Branch config
			properties.put("server.port", "8080");
		}
		
		app.setDefaultProperties(properties);
		app.run(args);
	}

}
