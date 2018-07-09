package za.co.digitalplatoon.invoiceservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tshegomasedi
 */

@Repository
@Transactional
public interface InvoiceDAO extends JpaRepository<Invoice, Long> {
}
