package pl.lodz.p.iap.hello;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloController {
    @GetMapping(value = "/hello")
    public String helloWorld() {
        return "Hello World!";
    }
}
