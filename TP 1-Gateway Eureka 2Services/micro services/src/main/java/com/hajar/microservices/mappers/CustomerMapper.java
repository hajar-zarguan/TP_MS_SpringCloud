package com.hajar.microservices.mappers;
import com.hajar.microservices.dto.CustomerRequestDto;
import com.hajar.microservices.dto.CustomerResponseDto;
import com.hajar.microservices.entities.Customer;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDto customerToCustomerResponse(Customer customer);
    Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto);
}
