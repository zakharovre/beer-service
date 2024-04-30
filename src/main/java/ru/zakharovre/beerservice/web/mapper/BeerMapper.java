package ru.zakharovre.beerservice.web.mapper;

import org.mapstruct.Mapper;
import ru.zakharovre.beerservice.domain.Beer;
import ru.zakharovre.beerservice.web.model.BeerDto;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
