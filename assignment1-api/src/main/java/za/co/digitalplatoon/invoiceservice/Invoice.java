package za.co.digitalplatoon.invoiceservice;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

/**
 * @author tshegomasedi
 */

@Entity
public class Invoice implements Serializable {

    private static final long serialVersionUID = -5693856457120519574L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String client;
    private long vatRate;
    private Date invoiceDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineItem> lineItems;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public long getVatRate() {
        return vatRate;
    }

    public void setVatRate(long vatRate) {
        this.vatRate = vatRate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public BigDecimal getSubTotal(){
        BigDecimal subTotal = BigDecimal.ZERO;
        lineItems.forEach(lineItem -> subTotal.add(lineItem.getLineItemTotal()));
        return subTotal.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getVat(){
        return getSubTotal().multiply(BigDecimal.valueOf(vatRate)).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotal(){
        return getSubTotal().add(getVat()).setScale(2, RoundingMode.HALF_UP);
    }
}
