package fr.formation.proxibanquev3.metier.entity;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Check;
@Entity
@DiscriminatorValue("CURRENT")
public class CurrentAccount extends Account {

	private CreditCard card;
	
	public CurrentAccount() {
		// TODO Auto-generated constructor stub
	}

	public CurrentAccount(Integer id, String number, Float balance, String type, LocalDate openDate, Check check) {
		super(id, number, balance, type, openDate, check);
		// TODO Auto-generated constructor stub
	}

	public CurrentAccount(String number, Float balance) {
		super(number, balance);
		// TODO Auto-generated constructor stub
	}

	public CurrentAccount(Integer id, String number, Float balance) {
		super(id, number, balance);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the card
	 */
	public CreditCard getCard() {
		return card;
	}

	/**
	 * @param card the card to set
	 */
	public void setCard(CreditCard card) {
		this.card = card;
	}

}
