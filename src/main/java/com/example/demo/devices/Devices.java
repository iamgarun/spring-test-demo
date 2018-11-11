package com.example.demo.devices;

public class Devices {
	
	private String deviceId;
	private String deviceDescription;
	private DeviceStatusEnum deviceStatus;
	
	public Devices(String deviceId, String deviceDescription, DeviceStatusEnum deviceStatus) {
		super();
		this.deviceId = deviceId;
		this.deviceDescription = deviceDescription;
		this.deviceStatus = deviceStatus;
	}
	
	private Devices(DevicesBuilder devicesBuilder) {
	
		this.deviceId = devicesBuilder.deviceId;
		this.deviceDescription = devicesBuilder.deviceDescription;
		this.deviceStatus = devicesBuilder.deviceStatus;
		
	}
	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceDescription() {
		return deviceDescription;
	}

	public void setDeviceDescription(String deviceDescription) {
		this.deviceDescription = deviceDescription;
	}

	public DeviceStatusEnum getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(DeviceStatusEnum deviceStatus) {
		this.deviceStatus = deviceStatus;
	}


	public static class DevicesBuilder{
		
		private String deviceId;
		private String deviceDescription;
		private DeviceStatusEnum deviceStatus;
		
		public DevicesBuilder withDeviceId(String deviceId){
			this.deviceId = deviceId;
			return this;
		}
		
		public DevicesBuilder withDeviceDescription(String deviceDescription) {
			this.deviceDescription = deviceDescription;
			return this;
		}
		
		public DevicesBuilder withDeviceStatus(DeviceStatusEnum deviceStatusEnum) {
			this.deviceStatus = deviceStatusEnum;
			return this;
		}
		
		public Devices build() {
			return new Devices(this);
		}
		
	}
	
}
