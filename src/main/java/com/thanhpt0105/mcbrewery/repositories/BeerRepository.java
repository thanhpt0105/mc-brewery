package com.thanhpt0105.mcbrewery.repositories;

import com.thanhpt0105.mcbrewery.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
