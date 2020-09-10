package com.thanhpt0105.mcbrewery.web.service;

import com.thanhpt0105.mcbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID id) {
        return BeerDto.builder().id(id).beerName("Tiger").beerStyle("Normal").build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName(beerDto.getBeerName())
                .beerStyle(beerDto.getBeerStyle())
                .build();
    }

    @Override
    public void updateBeer(UUID id, BeerDto beerDto) {
        //todo
    }

    @Override
    public void deleteBeer(UUID id) {
        log.info("delete beer " + id.toString());
    }
}
