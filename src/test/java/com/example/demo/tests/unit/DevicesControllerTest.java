package com.example.demo.tests.unit;

import com.example.demo.devices.DeviceStatusEnum;
import com.example.demo.devices.Devices;
import com.example.demo.devices.DevicesController;
import com.example.demo.devices.DevicesService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class DevicesControllerTest {

    private MockMvc mockMvc;

    @MockBean
    private DevicesService devicesService;

    @Before
    public void setUp() {
        DevicesController devicesController = new DevicesController(devicesService);

        Mockito.when(devicesService.getDevices())
                .thenReturn(Collections.singletonList(new Devices.DevicesBuilder()
                        .withDeviceDescription("OnePlus 6")
                        .withDeviceId("007")
                        .withDeviceStatus(DeviceStatusEnum.ACTIVE)
                        .build()));

        mockMvc = MockMvcBuilders.standaloneSetup(devicesController).build();
    }

    @Test
    public void getDevices_givenInvoked_shouldReturnDevicesList() throws Exception {

        mockMvc.perform(get("/rest/devices"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.length()", Matchers.is(1)))
                .andExpect(jsonPath("$[0].deviceId", Matchers.is("007")));

    }
}
