package br.com.project.challenge.entities.enums;

public enum ReservationStatus {
	
	CONFIRMED(1), CANCELED(2);
	
private int code;
	
	private ReservationStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static ReservationStatus valueOf(int code) {
		for (ReservationStatus value : ReservationStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Reservation Status code!!");
	}


}
