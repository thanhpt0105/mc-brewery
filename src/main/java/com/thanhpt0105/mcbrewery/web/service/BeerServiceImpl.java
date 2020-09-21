package com.thanhpt0105.mcbrewery.web.service;

import com.thanhpt0105.mcbrewery.domain.Beer;
import com.thanhpt0105.mcbrewery.repositories.BeerRepository;
import com.thanhpt0105.mcbrewery.web.controller.NotFoundException;
import com.thanhpt0105.mcbrewery.web.mappers.BeerMapper;
import com.thanhpt0105.mcbrewery.web.model.BeerDto;
import com.thanhpt0105.mcbrewery.web.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getBeerById(UUID id) {
        return beerMapper.beerToBeerDto(beerRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID id, BeerDto beerDto) {
        Beer beer = beerRepository.findById(id).orElseThrow(NotFoundException::new);
        //todo
        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());
        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }

    @Override
    public void deleteBeer(UUID id) {
        log.info("delete beer " + id.toString());
    }
}
