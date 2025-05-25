package pl.lodz.p.iap.domain;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SyncMessageDTO {
    private Long id;
    private Long reservationId;
	private Long syncId;
    private LocalDateTime syncTimestamp;
    private String address;
    private String port;

    public SyncMessageDTO(SyncMessage syncMessage) {
        this.id = syncMessage.getId();
        this.reservationId = syncMessage.getReservationId().getId();
        this.syncId = syncMessage.getSyncId();
        this.syncTimestamp = syncMessage.getSyncTimestamp();
        this.address = syncMessage.getAddress();
        this.port = syncMessage.getPort();
    }
}
