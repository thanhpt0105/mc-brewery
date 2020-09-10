package com.thanhpt0105.mcbrewery.web.service.v2;

import com.thanhpt0105.mcbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID id);
    BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto);
    void updateBeer(UUID id, BeerDtoV2 beerDto);
    void deleteBeer(UUID id);
}
