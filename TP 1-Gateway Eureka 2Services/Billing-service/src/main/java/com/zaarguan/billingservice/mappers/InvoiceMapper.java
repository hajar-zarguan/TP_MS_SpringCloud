package com.zaarguan.billingservice.mappers;
import com.zaarguan.billingservice.dto.InvoiceRequestDTO;
import com.zaarguan.billingservice.dto.InvoiceResponseDTO;
import com.zaarguan.billingservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO fromInvoice(Invoice invoice);
}
