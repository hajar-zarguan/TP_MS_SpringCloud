package com.hajar.microservices;

import com.hajar.microservices.service.CustomerService;
import com.hajar.microservices.dto.CustomerRequestDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServicesApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerService customerService){
        return args -> {
            customerService.save(new CustomerRequestDto("C01","Adria","adria@adria.com"));
            customerService.save(new CustomerRequestDto("C02","OpenLab","open@openLab.com"));
        };
    }

}
