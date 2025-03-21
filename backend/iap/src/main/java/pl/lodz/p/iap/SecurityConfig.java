package pl.lodz.p.iap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/hello").permitAll()  // Allow everyone to access /hello
                    .requestMatchers("/h2-console/**").permitAll()  // Allow everyone to access /h2-console
                    .requestMatchers("/favicon.ico").permitAll()
                    .anyRequest().authenticated()       // Secure all other endpoints
            )
            .csrf(AbstractHttpConfigurer::disable)
            .headers(headers -> headers
			.frameOptions(frameOptions -> frameOptions.disable()));
        return http.build();
    }
}
