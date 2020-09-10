package com.thanhpt0105.mcbrewery.web.service.v2;

import com.thanhpt0105.mcbrewery.web.model.v2.BeerDtoV2;
import com.thanhpt0105.mcbrewery.web.model.v2.BeerStyleEnumV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDtoV2 getBeerById(UUID id) {
        return BeerDtoV2.builder().id(id).beerName("Tiger").beerStyle(BeerStyleEnumV2.ALE).build();
    }

    @Override
    public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
        return BeerDtoV2.builder().id(UUID.randomUUID())
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .build();
    }

    @Override
    public void updateBeer(UUID id, BeerDtoV2 beerDto) {
        //todo
    }

    @Override
    public void deleteBeer(UUID id) {
        log.info("delete beer " + id.toString());
    }
}
