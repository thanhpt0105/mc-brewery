package com.thanhpt0105.mcbrewery.web.service;

import com.thanhpt0105.mcbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder().id(id).name("Random").build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name(customerDto.getName())
                .build();
    }

    @Override
    public void updateCustomer(UUID id, CustomerDto customerDto) {
        //todo
        log.info("update customer");
    }

    @Override
    public void deleteCustomer(UUID id) {
        log.info("delete customer");
    }
}
