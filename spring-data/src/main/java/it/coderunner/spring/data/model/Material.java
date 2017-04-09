package it.coderunner.spring.data.model;

import java.io.Serializable;

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
public class Material implements Serializable{
	
	private static final long serialVersionUID = -5153096510175773811L;
	
	@OneToMany(mappedBy = "material")
	public Part part;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String name;
	
	@Column
	private double density;
	
	@Column
	private double strength;
	
	@Column
	private double price;
	
	public Material(String name, double density, double strength, double price){
		this.name = name;
		this.density = density;
		this.strength = strength;
		this.price = price;
	}

}
