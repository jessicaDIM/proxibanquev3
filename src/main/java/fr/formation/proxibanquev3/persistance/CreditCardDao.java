package fr.formation.proxibanquev3.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import fr.formation.proxibanquev3.metier.entity.CreditCard;

/**
 * Classe regroupant les traitements � effectuer sur les cartes bleues. Respecte le
 * design pattern singleton.
 * 
 * @author Adminl
 *
 */
public class CreditCardDao extends AbstractDao<CreditCard> {

	private static final CreditCardDao INSTANCE = new CreditCardDao();
	
	public static CreditCardDao getInstance() {
		return CreditCardDao.INSTANCE;
	}

	@Override
	public CreditCard read(Integer id) {
		return this.read(id, new CreditCard());
	}


	@Override
	public List<CreditCard> readAll() {
		List<CreditCard> creditCards = new ArrayList<>();
		TypedQuery<CreditCard> query = this.em.createQuery(JpqlQueries.SELECT_ALL_CARDS, CreditCard.class);
		creditCards.addAll(query.getResultList());
		return creditCards;
	}



}

