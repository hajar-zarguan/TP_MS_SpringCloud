package com.hajar.microservices.web;

import com.hajar.microservices.dto.CustomerRequestDto;
import com.hajar.microservices.dto.CustomerResponseDto;
import com.hajar.microservices.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")

public class CustomerRestAPI {

    private CustomerService customerService;

    public CustomerRestAPI(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    public List<CustomerResponseDto> allCustomers(){
        return customerService.listCustomers();
    }
    @PostMapping(path = "/customers")
    public CustomerResponseDto save(@RequestBody CustomerRequestDto customerRequestDto){
        customerRequestDto.setId(UUID.randomUUID().toString());
        return customerService.save(customerRequestDto);
    }
    @GetMapping(path = "/customers/{id}")
    public CustomerResponseDto getCustomer(@PathVariable String id){
        return customerService.getCustomer(id);
    }
}




















