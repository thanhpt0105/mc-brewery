package com.thanhpt0105.mcbrewery.web.service;

import com.thanhpt0105.mcbrewery.domain.Beer;
import com.thanhpt0105.mcbrewery.web.model.BeerDto;
import com.thanhpt0105.mcbrewery.web.model.BeerPagedList;
import com.thanhpt0105.mcbrewery.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface BeerService {

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

    BeerDto getBeerById(UUID id);
    BeerDto saveNewBeer(BeerDto beerDto);
    BeerDto updateBeer(UUID id, BeerDto beerDto);
    void deleteBeer(UUID id);
}
