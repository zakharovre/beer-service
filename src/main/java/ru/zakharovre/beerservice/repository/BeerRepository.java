package ru.zakharovre.beerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.zakharovre.beerservice.domain.Beer;

import java.util.UUID;

@Repository
public interface BeerRepository extends JpaRepository<Beer, UUID> {

}
