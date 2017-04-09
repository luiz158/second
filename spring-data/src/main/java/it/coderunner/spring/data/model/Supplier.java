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
public class Supplier implements Serializable{
	
	private static final long serialVersionUID = -7672689326132913015L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String mailAddr;
	
	@Column
	private String phoneNo;
	
	
	public Supplier(String name, String mailAddr, String phoneNo){
		this.name = name;
		this.mailAddr = mailAddr;
		this.phoneNo = phoneNo;
	}	
	
}
