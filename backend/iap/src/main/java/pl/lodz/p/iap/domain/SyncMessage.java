package pl.lodz.p.iap.domain;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Table(name="syncmessage")
@Getter @Setter @NoArgsConstructor
public class SyncMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reservation_id")
    private Reservation reservationId;
    
    @Column(name = "sync_id")
	private Long syncId;
    
    @Column(name = "sync_timestamp", nullable = false)
    private LocalDateTime syncTimestamp;

    private String address;

    private String port; 

    public SyncMessage(Long id, Reservation reservationId, Long syncId, LocalDateTime syncTimestamp, String address, String port) {
        this.id = id;
        this.reservationId = reservationId;
        this.syncId = syncId;
        this.syncTimestamp = syncTimestamp;
        this.address = address;
        this.port = port;
    }

    //@PrePersist
    //public void run() {
    //    System.out.println("I have been called");
    //}
}
