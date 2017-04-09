package it.coderunner.spring.data.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Product implements Serializable {


	private static final long serialVersionUID = 753492514662450882L;

	@OneToMany(mappedBy="product")
	private Set<Part> parts;
	
	@Id
	@GeneratedValue
	private long productId;
	
	@Column 
	private String name;
	
	@Column(name="prod_year")
	private String prodYear;
	
	@Column(name="declaration_of_conformity")
	private String declOfConf;
	
	public Product(String name, String prodYear, String declOfConf){
		this.name = name;
		this.prodYear = prodYear;
		this.declOfConf = declOfConf;
	}
	
}
