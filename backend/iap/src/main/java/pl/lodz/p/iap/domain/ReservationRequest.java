package pl.lodz.p.iap.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ReservationRequest {
	private long carId;
	private long userId;
	private Date startDate;
	private Date endDate;

	public String toString() {
        String msg = "";
        msg += (" Car Id: " + this.carId);
        msg += (" User Id: " + this.userId);
        msg += (" Start date: " + this.startDate);
        msg += (" End date: " + this.endDate);
        return msg;
    }
}

