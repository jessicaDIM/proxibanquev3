package fr.formation.proxibanquev3.metier.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private String country;
	@Column
	private String city;
	@Column
	private String zipCode;
	@Column
	private String mainAddress;
	@Column
	private String secondAddress;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param country
	 * @param city
	 * @param zipCode
	 * @param mainAddress
	 * @param secondAddress
	 */
	public Address(String country, String city, String zipCode, String mainAddress, String secondAddress) {
		this.country = country;
		this.city = city;
		this.zipCode = zipCode;
		this.mainAddress = mainAddress;
		this.secondAddress = secondAddress;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the mainAddress
	 */
	public String getMainAddress() {
		return mainAddress;
	}

	/**
	 * @param mainAddress the mainAddress to set
	 */
	public void setMainAddress(String mainAddress) {
		this.mainAddress = mainAddress;
	}

	/**
	 * @return the secondAddress
	 */
	public String getSecondAddress() {
		return secondAddress;
	}

	/**
	 * @param secondAddress the secondAddress to set
	 */
	public void setSecondAddress(String secondAddress) {
		this.secondAddress = secondAddress;
	}
	
	

}
