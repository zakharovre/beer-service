package ru.zakharovre.beerservice.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.zakharovre.beerservice.domain.Beer;
import ru.zakharovre.beerservice.repository.BeerRepository;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Boobies")
                    .beerStyle("IPA")
                    .quantityToBrew(100)
                    .minOnHand(12)
                    .upc(48451515L)
                    .price(new BigDecimal("150.00"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Drunk Bums")
                    .beerStyle("WHEAT")
                    .quantityToBrew(50)
                    .minOnHand(12)
                    .upc(76469751L)
                    .price(new BigDecimal("120.00"))
                    .build());
        }
    }
}
