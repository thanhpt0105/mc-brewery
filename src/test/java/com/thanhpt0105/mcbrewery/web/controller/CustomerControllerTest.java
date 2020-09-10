package com.thanhpt0105.mcbrewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thanhpt0105.mcbrewery.web.model.BeerDto;
import com.thanhpt0105.mcbrewery.web.model.CustomerDto;
import com.thanhpt0105.mcbrewery.web.service.BeerService;
import com.thanhpt0105.mcbrewery.web.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    CustomerService service;

    @InjectMocks
    CustomerController controller;

    MockMvc mockMvc;

    CustomerDto validCustomer;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        validCustomer = CustomerDto.builder().id(UUID.randomUUID())
                .name("Thanh")
                .build();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void getCustomerById() throws Exception {
        when(service.getCustomerById(any())).thenReturn(validCustomer);

        mockMvc.perform(get("/api/v1/customer/" + validCustomer.getId().toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(validCustomer.getId().toString()))
                .andExpect(jsonPath("$.name").value("Thanh"));
    }
}