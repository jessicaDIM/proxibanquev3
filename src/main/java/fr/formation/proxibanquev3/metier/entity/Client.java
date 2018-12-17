package fr.formation.proxibanquev3.metier.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Repr�sentation d'un client de la banque.
 */
// Déclare cette classe en tant qu'entité gérée par JPA/Hibernate.
@Entity
// Déclare le lien avec la table SQL.
@Table(name = "client")
public class Client {

	/**
	 * Définition de l'identifiant JPA correspondant à la clé primaire en SQL.
	 */
	@Id
	// On précise que l'identifiant est une valeur générée par Auto-Increment.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column
	private String firstname;

	@Column
	private String lastname;

	@Column
	private LocalDate birthDate;

	@Column
	private Integer number;

	/*
	 * Déclaration d'une relation de Client 0/1 -> 0/n Account côté Java.
	 * 
	 * Cette relation donne toujours lieu à l'utilisation d'une List Java. Le
	 * lien effectué en base de données est configuré avec l'annotation
	 * suivante.
	 */
	@OneToMany
	/*
	 * Déclaration de la relation Client -> Compte en SQL. Une colonne de
	 * jointure utilisant une clé étrangère sera créée dans la table account.
	 * 
	 * 'columnDefinition' -> nom de l'attribut Java qui détermine l'identifiant
	 * de ma classe Client.
	 * 
	 * 'referencedColumnName' -> nom de l'attribut Java qui détermine
	 * l'identifiant de la classe cible Account.
	 * 
	 * 'name' -> nom de la colonne SQL de jointure comportant la clé étrangère.
	 * On conserve le nom 'accounts_id' choisi par Hibernate.
	 */
	@JoinColumn(name = "accounts_id", referencedColumnName = "id")
	private List<Account> accounts;
	@OneToOne
	private Address address;

	public Client() {
		this.accounts = new ArrayList()<>();
	}

	public Client(String firstname, String lastname, String email,
			String address) {
		this();
		this.firstname = firstname;
		this.lastname = lastname;
		
		
	}

	public Client(Integer id, String firstname, String lastname, String email,
			String address) {
		this(firstname, lastname, email, address);
		this.id = id;
	}

	public Client(Integer id, String firstname, String lastname, String email,
			String address, List<Account> accounts) {
		this(id, firstname, lastname, email, address);
		this.accounts = accounts;
	}

	

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the birthDate
	 */
	public LocalDate getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * @return the accounts
	 */
	public List<Account> getAccounts() {
		return accounts;
	}

	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Account getAccountById(Integer searchId) {
		Account result = null;
		for (Account a : this.accounts) {
			if (a.getId().equals(searchId)) {
				result = a;
				break;
			}
		}
		return result;
	}

}