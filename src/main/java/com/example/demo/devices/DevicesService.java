package com.example.demo.devices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DevicesService {
	
	public List<Devices> getDevices() {
		
		List<Devices> devicesList = new ArrayList<>(1);
		
		
		devicesList.add( new Devices.DevicesBuilder()
							.withDeviceDescription("OnePlus 6")
							.withDeviceId("007")
							.withDeviceStatus(DeviceStatusEnum.ACTIVE)
							.build());
		return devicesList;
		
	}

}
