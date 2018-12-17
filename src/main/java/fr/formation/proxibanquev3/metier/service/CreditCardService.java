package fr.formation.proxibanquev3.metier.service;

import java.time.LocalDate;

import fr.formation.proxibanquev3.metier.entity.CreditCard;
import fr.formation.proxibanquev3.persistance.CreditCardDao;
/**
 * Classe regroupant les traitements à effectuer sur les cartes de crédits. Respecte le
 * design pattern singleton.
 * 
 * @author Jessica Di Marco & Sandy Colin
 *
 */
public class CreditCardService {
	
	private static final CreditCardService INSTANCE = new CreditCardService();

	/**
	 * Retourne le singleton de la classe.
	 * 
	 * @return Le singleton.
	 */
	public static CreditCardService getInstance() {
		return CreditCardService.INSTANCE;
	}

	private CreditCardDao daoCard;

	public CreditCardService() {
		this.daoCard = CreditCardDao.getInstance();
	}

	/**
	 * Méthode permettant de créer une nouvelle carte de crédit
	 * @param number numéro de la carte
	 * @param type   type de la carte (Visa,...)
	 * @param expirationDate date d'expiration de la carte
	 * @return un nouvel objet CreditCard
	 */
	public CreditCard create(String number, String type, LocalDate expirationDate) {
		return this.daoCard.create(new CreditCard(number, type, expirationDate));
	}
	/**
	 * Supprime une carte de crédit selon son id
	 * @param id identifiant de la carte de crédit
	 */
	public void delete(Integer id) {
		this.daoCard.delete(id);
	}

}
