package it.coderunner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.coderunner.dao.InvoiceDAO;
import it.coderunner.dao.PersonDAO;
import it.coderunner.model.Invoice;
import it.coderunner.model.Person;

public class SpringHibernateMain {

	
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("spring.xml");
		
		PersonDAO personDAO = context.getBean(PersonDAO.class);
		
		Person person = new Person();
		person.setName("Michał");
		person.setCountry("Poland");
		

		personDAO.save(person);
		
		System.out.println("Person::" + person);

		personDAO.list().forEach(System.out::println);

		context.close();

		InvoiceDAO invoiceDAO = context1.getBean(InvoiceDAO.class);

		Invoice invoice = new Invoice();
		invoice.setDate("21.03.2015");
		invoice.setSum(15500.99);

		invoiceDAO.save(invoice);
		invoiceDAO.list().forEach(System.out::println);
	
		System.out.println("Invoice::" + invoice);
		context1.close();
	}

}
