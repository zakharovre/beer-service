package ru.zakharovre.beerservice.service;

import org.springframework.http.ResponseEntity;
import ru.zakharovre.beerservice.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {

    BeerDto getBeerById(UUID beerId);

    BeerDto updateBeerById(UUID beerId, BeerDto beerDto);

    BeerDto createBeer(BeerDto beerDto);
}
