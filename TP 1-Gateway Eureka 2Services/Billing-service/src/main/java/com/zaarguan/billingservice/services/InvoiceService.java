package com.zaarguan.billingservice.services;


import com.zaarguan.billingservice.dto.InvoiceRequestDTO;
import com.zaarguan.billingservice.dto.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO getInvoice(String id);
    List<InvoiceResponseDTO> invoicesByCustomer(String customerID);
    List<InvoiceResponseDTO> allInvoices();
}
