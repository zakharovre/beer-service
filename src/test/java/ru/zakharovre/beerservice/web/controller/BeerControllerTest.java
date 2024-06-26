package ru.zakharovre.beerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.zakharovre.beerservice.web.model.BeerDto;
import ru.zakharovre.beerservice.web.model.BeerStyleEnum;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createBeer() throws Exception {

        String beerDtoAsJson = objectMapper.writeValueAsString(getValidBeerDto());

        mockMvc.perform(post("/api/v1/beer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoAsJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        String beerDtoAsJson = objectMapper.writeValueAsString(getValidBeerDto());

        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoAsJson))
                .andExpect(status().isNoContent());
    }

    BeerDto getValidBeerDto() {
        return BeerDto.builder()
                .beerName("Pee")
                .beerStyle(BeerStyleEnum.WHEAT)
                .upc(123123123L)
                .price(BigDecimal.valueOf(150.50))
                .build();
    }
}
