package com.thanhpt0105.mcbrewery.web.service;

import com.thanhpt0105.mcbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID id);
    CustomerDto saveNewCustomer(CustomerDto customerDto);
    void updateCustomer(UUID id, CustomerDto customerDto);
    void deleteCustomer(UUID id);
}
