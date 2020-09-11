package com.thanhpt0105.mcbrewery.bootstrap;

import com.thanhpt0105.mcbrewery.domain.Beer;
import com.thanhpt0105.mcbrewery.repositories.BeerRepository;
import com.thanhpt0105.mcbrewery.web.model.BeerStyleEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class DataLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public DataLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .id(UUID.randomUUID())
                    .beerName("Tiger")
                    .beerStyle(BeerStyleEnum.ALE.toString())
                    .minOnHand(12)
                    .price(new BigDecimal("10.0"))
                    .build());

            beerRepository.save(Beer.builder()
                    .id(UUID.randomUUID())
                    .beerName("Saigon")
                    .beerStyle(BeerStyleEnum.GOSE.toString())
                    .minOnHand(10)
                    .price(new BigDecimal("12.0"))
                    .build());
        }
    }
}
