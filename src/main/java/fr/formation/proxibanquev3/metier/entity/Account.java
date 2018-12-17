package fr.formation.proxibanquev3.metier.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



//Déclare cette classe en tant qu'entité gérée par JPA/Hibernate.
	@Entity
	// Lien avec la table SQL unique.
	@Table(name = "account")
	// Déclaration d'une hierarchie dans les clases Java d'entité.
	// La stratégie SINGLE_TABLE précise qu'il n'y aura toujours qu'une seule table SQL pour tous les types de comptes.
	@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
	// Déclare la colonne SQL à utiliser pour différencier les sous-classes de Account (soit CurrentAccount ou SavingsAccount).
	@DiscriminatorColumn(name = "type")
	/*
	 * L'annotation ci-dessous est désactivée car elle ne fonctionne que si la
	 * classe mère Account n'est JAMAIS utilisée dans les entités. Or on l'utilise
	 * dans la classe Client avec List<Account>. On doit donc utiliser @Entity à la
	 * place. Il ne peut il y avoir qu'une des deux annotations @Entity
	 * ou @MappedSuperclass sur une entité JPA.
	 */
	//@MappedSuperclass
	public class Account {

		/**
		 * Identifiant technique base de donnees.
		 */
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column
		private Integer id;

		/**
		 * Identifiant meier, numero du compte sur 9 chiffres.
		 */
		@Column
		private String number;

		/**
		 * Stockage du solde actuel de ce compte en euros.
		 */
		@Column
		private Float balance;
		
		@Column
		private LocalDate openDate;
		
		@OneToOne
		@JoinColumn(name="chequeId")
		private Cheque cheque;

		public Account() {
			this.balance = 0F;
		}

		/**
		 * @param id
		 * @param number
		 * @param balance
		 * @param type
		 * @param openDate
		 * @param check
		 */
		public Account(Integer id, String number, Float balance, LocalDate openDate, Cheque cheque) {
			this.id = id;
			this.number = number;
			this.balance = balance;
			this.openDate = openDate;
			this.cheque = cheque;
		}



		public Account(String number, Float balance) {
			this();
			this.number = number;
			this.balance = balance;
		}

		public Account(Integer id, String number, Float balance) {
			this(number, balance);
			this.id = id;
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

		public Float getBalance() {
			return balance;
		}

		public void setBalance(Float balance) {
			this.balance = balance;
		}

	}

