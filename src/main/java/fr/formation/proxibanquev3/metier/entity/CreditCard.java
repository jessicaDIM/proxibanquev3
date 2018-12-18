package fr.formation.proxibanquev3.metier.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Représentation d'une carte de crédit.
 * @author Jessica Di Marco & Sandy Colin
 */
@Entity
@Table(name="creditcard")
public class CreditCard {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String number;
	
	@Column
	private String type;
	
	@Column
	private LocalDate expirationDate;
	
	public CreditCard() {
	}
	
	public CreditCard(String number, String type, LocalDate expirationDate) {
		this.number = number;
		this.type = type;
		this.expirationDate=expirationDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the expirationDate
	 */
	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}
	
}

