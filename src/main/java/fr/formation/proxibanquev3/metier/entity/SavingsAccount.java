package fr.formation.proxibanquev3.metier.entity;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Check;

@Entity
@DiscriminatorValue("SAVINGS")
public class SavingsAccount extends Account {

	public SavingsAccount() {
		// TODO Auto-generated constructor stub
	}

	public SavingsAccount(Integer id, String number, Float balance, String type, LocalDate openDate, Check check) {
		super(id, number, balance, type, openDate, check);
		// TODO Auto-generated constructor stub
	}

	public SavingsAccount(String number, Float balance) {
		super(number, balance);
		// TODO Auto-generated constructor stub
	}

	public SavingsAccount(Integer id, String number, Float balance) {
		super(id, number, balance);
		// TODO Auto-generated constructor stub
	}

}
