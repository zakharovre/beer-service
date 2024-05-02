package ru.zakharovre.beerservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.zakharovre.beerservice.repository.BeerRepository;
import ru.zakharovre.beerservice.web.controller.NotFoundException;
import ru.zakharovre.beerservice.web.mapper.BeerMapper;
import ru.zakharovre.beerservice.web.model.BeerDto;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getBeerById(UUID beerId) {
        return beerMapper.beerToBeerDto(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto updateBeerById(UUID beerId, BeerDto beerDto) {
        return null;
    }

    @Override
    public BeerDto createBeer(BeerDto beerDto) {
        return null;
    }
}
