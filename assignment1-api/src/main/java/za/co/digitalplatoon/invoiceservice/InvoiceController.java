package za.co.digitalplatoon.invoiceservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.digitalplatoon.invoiceservice.exception.InternalServerException;
import za.co.digitalplatoon.invoiceservice.exception.ResourceNotFoundException;

import java.util.List;

/**
 * @author tshegomasedi
 */

@RestController
@RequestMapping("/")
public class InvoiceController {

    private InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("invoices")
    public List<Invoice> getAllInvoices(){
        return invoiceService.getAllInvoices();
    }

    @GetMapping("invoice/{id}")
    public Invoice getInvoiceById(@PathVariable(value = "id") Long playerId){
        return invoiceService.getInvoiceById(playerId).orElseThrow(() -> new ResourceNotFoundException("Invoice", "id", playerId));
    }

    @PostMapping("/invoice")
    public Invoice addInvoice(@RequestBody Invoice invoice){
        try {
            return invoiceService.addInvoice(invoice);
        } catch (Exception e) {
            throw new InternalServerException("Invoice");
        }
    }
}
