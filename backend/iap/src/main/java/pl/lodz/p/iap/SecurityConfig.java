package pl.lodz.p.iap;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> 
                cors.configurationSource(request -> {
                    CorsConfiguration configuration = new CorsConfiguration();
                    configuration.setAllowedOrigins(Arrays.asList("*"));
                    configuration.setAllowedMethods(Arrays.asList("*"));
                    configuration.setAllowedHeaders(Arrays.asList("*"));
                    return configuration;
                })
            )
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/hello").hasRole("USER")
                    .requestMatchers("/h2-console/**").permitAll()  // Allow everyone to access /h2-console
                    .requestMatchers("/favicon.ico").permitAll()
                    .requestMatchers("/rentUsers").permitAll()
                    .requestMatchers("/rentUser/**").permitAll()
                    .requestMatchers("/addRentUser").permitAll()
                    .requestMatchers("/reservations").permitAll()
                    .requestMatchers("/reservation/**").permitAll()
                    .requestMatchers("/addReservation").permitAll()
                    .requestMatchers("/cars").permitAll()
                    .requestMatchers("/car/**").permitAll()
                    .requestMatchers("/addCar").permitAll()
                    .anyRequest().authenticated()       // Secure all other endpoints
            )
            .httpBasic(Customizer.withDefaults())
            .sessionManagement((session) -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .csrf(AbstractHttpConfigurer::disable)
            .headers(headers -> headers
			.frameOptions(frameOptions -> frameOptions.disable()));
        return http.build();
    }

    @Bean
	public AuthenticationManager authenticationManager(
			UserDetailsService userDetailsService,
			PasswordEncoder passwordEncoder) {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder);

		return new ProviderManager(authenticationProvider);
	}

    @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
