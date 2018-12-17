package fr.formation.proxibanquev3.metier.service;

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

	
	public CreditCard create(String number, String type) {
		return this.daoCard.create(new CreditCard(number, type));
	}

	public void delete(Integer id) {
		this.daoCard.delete(id);
	}

}
