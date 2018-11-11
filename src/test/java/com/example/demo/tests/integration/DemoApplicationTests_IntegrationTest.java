package com.example.demo.tests.integration;

import com.example.demo.devices.DevicesController;
import com.example.demo.devices.DevicesService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests_IntegrationTest {

	private MockMvc mockMvc;

	@Autowired
	private DevicesService devicesService;

	@Before
	public void setUp() {
		DevicesController devicesController = new DevicesController(devicesService);
		mockMvc = MockMvcBuilders.standaloneSetup(devicesController).build();

	}

	@Test
	public void getDevices_whenInvoked_shouldGiveDeviceList() throws Exception {
		mockMvc.perform(get("/rest/devices"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$.length()", Matchers.is(1)))
				.andExpect(jsonPath("$[0].deviceId", Matchers.is("007")));
	}

}