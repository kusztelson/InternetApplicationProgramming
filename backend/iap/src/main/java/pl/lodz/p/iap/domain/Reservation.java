package pl.lodz.p.iap.domain;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="car_id", nullable=false)
	private Car carId;
    
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
	private RentUser userId;
    
    @Column(name = "start_date")
	private Date startDate;

    @Column(name = "end_date")
	private Date endDate;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Car getCarId() {
        return carId;
    }
    public void setCarId(Car carId) {
        this.carId = carId;
    }
    public RentUser getUserId() {
        return userId;
    }
    public void setUserId(RentUser userId) {
        this.userId = userId;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEnd_date(Date endDate) {
        this.endDate = endDate;
    }
}
