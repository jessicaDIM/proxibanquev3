package fr.formation.proxibanquev3.metier.entity;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Représentation d'un chèquier bancaire
 * @author Jessica Di Marco & Sandy Colin
 */
@Entity
@Table(name="cheque")
public class Cheque {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	@Column
	private LocalDate sendDate;
	@Column
	private LocalDate receptionDate;
	
	public Cheque() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param sendDate
	 * @param receptionDate
	 */
	public Cheque(Integer id, LocalDate sendDate, LocalDate receptionDate) {
		this.id = id;
		this.sendDate = sendDate;
		this.receptionDate = receptionDate;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the sendDate
	 */
	public LocalDate getSendDate() {
		return sendDate;
	}

	/**
	 * @param sendDate the sendDate to set
	 */
	public void setSendDate(LocalDate sendDate) {
		this.sendDate = sendDate;
	}

	/**
	 * @return the receptionDate
	 */
	public LocalDate getReceptionDate() {
		return receptionDate;
	}

	/**
	 * @param receptionDate the receptionDate to set
	 */
	public void setReceptionDate(LocalDate receptionDate) {
		this.receptionDate = receptionDate;
	}
	@Override
	public String toString() {
		return this.id + "=" + this.receptionDate;
	}
}
