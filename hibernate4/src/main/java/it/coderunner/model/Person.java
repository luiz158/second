package it.coderunner.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "PERSON")
public class Person {

	@OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
	private Set<Invoice> invoices;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "username")
	private String name;

	private String country;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<Invoice> getSetInv() {
		return invoices;
	}

	public void setSetInv(Set<Invoice> invoices) {
		this.invoices = invoices;

	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", country=" + country;
	}
}
