package com.thanhpt0105.mcbrewery.web.mappers;

import com.thanhpt0105.mcbrewery.domain.Beer;
import com.thanhpt0105.mcbrewery.web.model.BeerDto;
import com.thanhpt0105.mcbrewery.web.service.inventory.BeerInventoryService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BeerMapperDecorator implements BeerMapper {
    @Autowired
    private BeerInventoryService beerInventoryService;
    @Autowired
    private BeerMapper beerMapper;

    @Override
    public BeerDto beerToBeerDtoWithInventory(Beer beer) {
        BeerDto beerDto = beerMapper.beerToBeerDto(beer);
        beerDto.setQuantityOnHand(beerInventoryService.getOnHandInventory(beer.getId()));
        return beerDto;
    }
}
