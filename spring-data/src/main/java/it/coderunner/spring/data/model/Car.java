package it.coderunner.spring.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Car implements Serializable {

	private static final long serialVersionUID = -7008442906450193405L;


	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String manufacturer;

	@Column(nullable = false)
	private String model;
	
	@Column(nullable = false)
	private String prodYear;
	
	
	public Car(String manufacturer, String model, String prodYear){
		this.manufacturer = manufacturer;
		this.model = model;
		this.prodYear = prodYear;
	}

}