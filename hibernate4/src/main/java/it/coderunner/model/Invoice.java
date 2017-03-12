package it.coderunner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INVOICE")
public class Invoice {
	
	@Id
	@Column(name = "in_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id")
	private Person person;
	
	private String date;
	
	private double sum;
	
	public int getinId() {
		return inId;
	}

	public void setinId(int inId) {
		this.inId = inId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}
	
	public Person getPerson(){
		return person;
	}
	
	public void setPerson(Person person){
		this.person = person;
	}
	
	@Override
	public String toString() {
		return "in_id=" + inId + ", date=" + date + ", sum=" + sum;
	}
	
	

}
