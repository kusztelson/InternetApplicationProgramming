package pl.lodz.p.iap.domain;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Reservation")
@Getter @Setter @NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
	private Car carId;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
	private RentUser userId;
    
    @Column(name = "start_date", nullable = false)
	private Date startDate;

    @Column(name = "end_date")
	private Date endDate;

    @JsonIgnore
    @OneToOne(mappedBy = "reservationId", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "sync_message")
    private SyncMessage syncMessage;
    
    public Reservation(long id, Car carId, RentUser userId, Date startDate, Date endDate) {
        this.id = id;
        this.carId = carId;
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String toString() {
        String msg = "";
        msg += ("Id: " + this.id);
        msg += (" Car Id: " + this.carId);
        msg += (" User Id: " + this.userId);
        msg += (" Start date: " + this.startDate);
        msg += (" End date: " + this.endDate);
        msg += (" Sync: " + this.syncMessage);
        return msg;
    }
}
