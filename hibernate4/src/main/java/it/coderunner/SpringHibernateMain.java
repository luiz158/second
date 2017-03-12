package it.coderunner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.coderunner.dao.InvoiceDAO;
import it.coderunner.dao.PersonDAO;
import it.coderunner.model.Invoice;
import it.coderunner.model.Person;

public class SpringHibernateMain {

	
	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		PersonDAO personDAO = context.getBean(PersonDAO.class);
		
		Person person = new Person();
		person.setName("Michał");
		person.setCountry("Poland");
		int i=1;
		Person personToUpdate = new Person();
		personToUpdate=personDAO.selectByID(i);
		personToUpdate.setName("Jan");
		personDAO.update(personToUpdate);

		
		System.out.println(personDAO.save(person));
//		person.setName("Krzysztof");
//		System.out.println(personDAO.update(person));
		
		System.out.println("Person::" + person);
		
		personDAO.list().forEach(System.out::println);
		System.out.println(personDAO.selectByID(i));
		

		InvoiceDAO invoiceDAO = context.getBean(InvoiceDAO.class);

		Invoice invoice = new Invoice();
		invoice.setDate("21.03.2015");
		invoice.setSum(15500.99);
		invoice.setPerson(person);
		
		Invoice invoice2 = new Invoice();
		invoice2.setDate("01.01.2017");
		invoice2.setSum(125500.00);
		invoice2.setPerson(person);

		System.out.println(invoiceDAO.save(invoice));
		System.out.println(invoiceDAO.save(invoice2));
		invoiceDAO.list().forEach(System.out::println);
	
		System.out.println("Invoice::" + invoice);
		System.out.println(personDAO.selectByID(i).getSetInv());
		context.close();
	}

}
