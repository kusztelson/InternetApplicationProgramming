package pl.lodz.p.iap.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Car")
@Getter @Setter @NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
	private String name;
    
    @Column(nullable = false)
    private String picture;
    
    @Column(name = "price_per_day", nullable = false)
	private float pricePerDay;
    @Column(name = "Category",nullable = false)
    private String category;

    public Car(long id, String name, String picture, float pricePerDay,String category) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.pricePerDay = pricePerDay;
        this.category = category;
    }
}
