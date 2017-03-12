package it.coderunner.dao;

import java.util.List;

import it.coderunner.model.Invoice;

public interface InvoiceDAO {

Invoice save(Invoice i);
Invoice update(Invoice i);
	
	List<Invoice> list();
}
