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
}
