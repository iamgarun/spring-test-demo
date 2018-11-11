package com.example.demo.devices;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rest")
public class DevicesController {
	
	private DevicesService devicesService;
	
	
	public DevicesController(DevicesService devicesService) {
		super();
		this.devicesService = devicesService;
	}

	@GetMapping(path = "/devices")
	public ResponseEntity<List<Devices>> getDevices(){
		
		return new ResponseEntity<>(devicesService.getDevices(), HttpStatus.OK);
		
		
		
	}
	
}
