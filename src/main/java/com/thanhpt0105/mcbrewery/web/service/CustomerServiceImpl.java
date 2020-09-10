package com.thanhpt0105.mcbrewery.web.service;

import com.thanhpt0105.mcbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder().id(id).name("Random").build();
    }
}
