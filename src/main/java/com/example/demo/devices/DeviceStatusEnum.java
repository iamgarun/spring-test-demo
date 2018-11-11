package com.example.demo.devices;

public enum DeviceStatusEnum {
	

	ACTIVE("A"),
	
	INACTIVE("I");
	
	private String statusCode;

	DeviceStatusEnum(String statusCode) {
		
		this.setString(statusCode);
	}

	String getString() {
		return statusCode;
	}

	void setString(String string) {
		this.statusCode = string;
	}

}
