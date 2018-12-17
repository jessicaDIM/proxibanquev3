package fr.formation.proxibanquev3.metier.service;

import java.time.LocalDate;

import fr.formation.proxibanquev3.metier.entity.Cheque;
import fr.formation.proxibanquev3.metier.entity.CreditCard;
import fr.formation.proxibanquev3.persistance.CheckDao;
import fr.formation.proxibanquev3.persistance.CreditCardDao;
/**
 * Clsse regroupant les traitements � effectuer sur les clients. Respecte le
 * design pattern singleton.
 * 
 * @author Jessica Di Marco & Sandy Colin
 *
 */
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

	/**
	 * Méthode permettant de créer un nouveau chéquier
	 * @param id identifiant du chéquier
	 * @param sendDate date d'envoi du chéquier
	 * @param réceptionDate date de reception du chéquier
	 * @return un nouvel objet CreditCard
	 */
	public Cheque create(Integer id, LocalDate sendDate, LocalDate receptionDate) {
		return this.daoCard.create(new Cheque(id, sendDate, receptionDate));
	}
	/**
	 * Supprime un chéquier selon son id
	 * @param id identifiant du chéquier
	 */
	public void delete(Integer id) {
		this.daoCard.delete(id);
	}
}
