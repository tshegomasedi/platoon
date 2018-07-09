package za.co.digitalplatoon.invoiceservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * @author tshegomasedi
 */

@Service
public class InvoiceService {

    private InvoiceDAO invoiceDAO;

    @Autowired
    public InvoiceService(InvoiceDAO invoiceDAO) {
        this.invoiceDAO = invoiceDAO;
    }

    public List<Invoice> getAllInvoices(){
        return invoiceDAO.findAll();
    }

    public Optional<Invoice> getInvoiceById(long id) {
        return invoiceDAO.findById(id);
    }

    public Invoice addInvoice(Invoice invoice){
        return invoiceDAO.save(invoice);
    }

}
