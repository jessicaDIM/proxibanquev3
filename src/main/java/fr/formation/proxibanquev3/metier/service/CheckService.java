package fr.formation.proxibanquev3.metier.service;

import java.time.LocalDate;

import fr.formation.proxibanquev3.metier.entity.CreditCard;
import fr.formation.proxibanquev3.persistance.CheckDao;
import fr.formation.proxibanquev3.persistance.CreditCardDao;

public class CheckService {

	
	private static final CheckService INSTANCE = new CheckService();

	/**
	 * Retourne le singleton de la classe.
	 * 
	 * @return Le singleton.
	 */
	public static CheckService getInstance() {
		return CheckService.INSTANCE;
	}

	private CheckDao daoCard;

	public CheckService() {
		this.daoCard = CheckDao.getInstance();
	}

	
	public Cheque create(String number, String type, LocalDate expirationDate) {
		return this.daoCard.create(new CreditCard(number, type, expirationDate));
	}

	public void delete(Integer id) {
		this.daoCard.delete(id);
	}
}
