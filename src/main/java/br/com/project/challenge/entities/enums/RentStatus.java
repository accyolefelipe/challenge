package br.com.project.challenge.entities.enums;

public enum RentStatus {
	
	DELAYED(1), WINTHIN_THE_TIME_LIMIT(2);
	
	private int code;
	
	private RentStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static RentStatus valueOf(int code) {
		for (RentStatus value : RentStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Rent Status code!!");
	}

}
