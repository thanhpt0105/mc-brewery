package com.thanhpt0105.mcbrewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thanhpt0105.mcbrewery.bootstrap.DataLoader;
import com.thanhpt0105.mcbrewery.web.model.BeerDto;
import com.thanhpt0105.mcbrewery.web.model.BeerStyleEnum;
import com.thanhpt0105.mcbrewery.web.service.BeerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class BeerControllerTest {

    @Mock
    BeerService service;

    @InjectMocks
    BeerController controller;

    MockMvc mockMvc;

    BeerDto validBeer;

    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        validBeer = BeerDto.builder().id(UUID.randomUUID())
                .beerName("My Beer")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal("2.99"))
                .upc(DataLoader.BEER_1_UPC)
                .build();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void getBeer() throws Exception {
        when(service.getBeerById(any(), any())).thenReturn(validBeer);

        mockMvc.perform(get("/api/v1/beer/" + validBeer.getId().toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(validBeer.getId().toString()))
                .andExpect(jsonPath("$.beerName").value(validBeer.getBeerName()));
    }

    @Test
    void handlePost() throws Exception {
        BeerDto beerDto = validBeer;
        beerDto.setId(null);
        String beerDto2Json = objectMapper.writeValueAsString(beerDto);

        BeerDto newBeer = BeerDto.builder().id(UUID.randomUUID()).beerName("New").build();

        when(service.saveNewBeer(any())).thenReturn(newBeer);

        mockMvc.perform(post("/api/v1/beer/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(beerDto2Json))
                .andExpect(status().isCreated());
    }

    @Test
    void handleUpdate() throws Exception {
        BeerDto beerDto = validBeer;
        beerDto.setId(null);
        String beerDto2Json = objectMapper.writeValueAsString(beerDto);

        when(service.updateBeer(any(), any())).thenReturn(validBeer);

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(beerDto2Json))
                .andExpect(status().isNoContent());

    }

    @Test
    void handleDelete() throws Exception {
        mockMvc.perform(delete("/api/v1/beer/" + UUID.randomUUID().toString()))
                .andExpect(status().isNoContent());
        verify(service).deleteBeer(any());
    }
}