package com.hajar.microservices.service;

import com.hajar.microservices.repositories.CustomerRepository;
import com.hajar.microservices.dto.CustomerRequestDto;
import com.hajar.microservices.dto.CustomerResponseDto;
import com.hajar.microservices.entities.Customer;
import com.hajar.microservices.mappers.CustomerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDto save(CustomerRequestDto customerRequestDto) {
        Customer customer = customerMapper.customerRequestDtoToCustomer(customerRequestDto);
        System.out.println("************************************************************8888");
        System.out.println(customer.getName());
        System.out.println("************************************************************8888");
        Customer saveCustomer = customerRepository.save(customer);
        CustomerResponseDto customerResponseDto = customerMapper.customerToCustomerResponse(saveCustomer);
        return customerResponseDto;
    }

    @Override
    public CustomerResponseDto getCustomer(String id) {
        Customer customer = customerRepository.findById(id).get();
        return customerMapper.customerToCustomerResponse(customer);
    }

    @Override
    public CustomerResponseDto update(CustomerRequestDto customerRequestDto) {
        Customer customer = customerMapper.customerRequestDtoToCustomer(customerRequestDto);
        Customer updatedCustomer = customerRepository.save(customer);
        CustomerResponseDto customerResponseDto = customerMapper.customerToCustomerResponse(updatedCustomer);
        return customerResponseDto;

    }

    @Override
    public List<CustomerResponseDto> listCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerResponseDto> customerResponseDtos = customerList.stream().map(customer -> customerMapper.customerToCustomerResponse(customer)).collect(Collectors.toList());
        return customerResponseDtos;
    }
}










































