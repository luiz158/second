package it.coderunner.spring.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Part implements Serializable{

	private static final long serialVersionUID = -1964692699697477124L;
		
	@Id
	@Column(name="part_id")
	@GeneratedValue
	private long partId;

	@ManyToOne
	@JoinColumn(name="product_id")
	public Product product;
	
	@ManyToOne
	@JoinColumn(name="material_id")
	public Material material;
	
	@ManyToOne
	@JoinColumn(name="supplier_id")
	public Supplier supplier;
	
	@Column
	private String name;
	
	@Column
	private String partNo;
	
	@Column
	private double price;
	
	public Part(String name, String partNo, Material material, Supplier supplier, double price){
		this.name = name;
		this.partNo = partNo;
		this.material = material;
		this.supplier = supplier;
		this.price = price;
	}
	
}
