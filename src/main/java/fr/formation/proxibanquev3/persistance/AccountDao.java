package fr.formation.proxibanquev3.persistance;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import fr.formation.proxibanquev3.metier.entity.Account;

/**
 * Classe permettant les opérations du C.R.U.D pour les comptes des clients.
 * Respecte le design pattern singleton.
 * 
 * @author  Jessica Di Marco & Sandy Colin
 *
 */
public class AccountDao extends AbstractDao<Account> {
	
private static final AccountDao INSTANCE = new AccountDao();
	
	public static AccountDao getInstance() {
		return AccountDao.INSTANCE;
	}
	/**
	 * {@inheritDoc}
	 * Lit les informations d'un compte donné selon son id
	 */
	public Account read(Integer id) {
		return this.read(id, new Account());
	}

	@Override
	/**
	 * {@inheritDoc}
	 * Récupère tous les comptes dans une liste
	 */
	
	public List<Account> readAll() {
		List<Account> accounts = new ArrayList<>();
		TypedQuery<Account> query = this.em.createQuery(JpqlQueries.SELECT_ACCOUNTS, Account.class);
		accounts.addAll(query.getResultList());
		return accounts;
	}


}

