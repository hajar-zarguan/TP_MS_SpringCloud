package com.zaarguan.billingservice.web;


import com.zaarguan.billingservice.dto.InvoiceRequestDTO;
import com.zaarguan.billingservice.dto.InvoiceResponseDTO;
import com.zaarguan.billingservice.services.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class InvoiceRestController {
    private InvoiceService invoiceService;

    public InvoiceRestController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping(path = "/invoices/{id}")
    public InvoiceResponseDTO getInvoice(@PathVariable(name = "id") String id){
        return invoiceService.getInvoice(id);
    }

    @PostMapping(path = "/invoices/")
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO){
        return invoiceService.save(invoiceRequestDTO);
    }

    @GetMapping(path = "/invoicesByCustomer/{customerId}")
    public List<InvoiceResponseDTO> getInvoicesByCustomer(@PathVariable(name = "customerId")String customerId){
        return invoiceService.invoicesByCustomer(customerId);
    }

    @GetMapping(path = "/invoices")
    public List<InvoiceResponseDTO> getAllInvoices(){
        return invoiceService.allInvoices();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String > exceptionHandler(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
