package pl.lodz.p.iap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RentUser")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RentUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
	private String login;

    @Column(nullable = false)
	private String password;

    @Column(nullable = false)
	private String name;

    @Column(nullable = false)
	private String surname;
    
    @Column(nullable = false, name = "rent_user_role")
	private String role;

    @JsonIgnore
    @JsonProperty(value = "password")
    public String getPassword() {
        return password;
    }
}
