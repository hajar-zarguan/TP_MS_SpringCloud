package com.hajar.microservices.service;

import com.hajar.microservices.dto.CustomerRequestDto;
import com.hajar.microservices.dto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    CustomerResponseDto save (CustomerRequestDto customerRequestDto);
    CustomerResponseDto getCustomer (String id);
    CustomerResponseDto update (CustomerRequestDto customerRequestDto);
    List<CustomerResponseDto> listCustomers();


}
