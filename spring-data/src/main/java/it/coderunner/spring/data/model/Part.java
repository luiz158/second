package it.coderunner.spring.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Part implements Serializable{

	private static final long serialVersionUID = -1964692699697477124L;
	
	@ManyToOne
	public Product product;
		
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String partNo;
	
	@Column
	private String material;
	
	@Column 
	private String supplier;
	
	@Column
	private double price;
	
	public Part(String name, String partNo, String material, String supplier, double price){
		this.name = name;
		this.partNo = partNo;
		this.material = material;
		this.supplier = supplier;
		this.price = price;
	}
	
}
