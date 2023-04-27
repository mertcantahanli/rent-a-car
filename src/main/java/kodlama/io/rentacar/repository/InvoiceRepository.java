package kodlama.io.rentacar.repository;

import kodlama.io.rentacar.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
