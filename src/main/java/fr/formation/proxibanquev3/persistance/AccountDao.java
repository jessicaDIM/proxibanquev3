package fr.formation.proxibanquev3.persistance;

/**
 * Classe permettant les op�rations du C.R.U.D pour les comptes des clients.
 * Respecte le design pattern singleton.
 * 
 * @author Adminl
 *
 */
public class AccountDao extends AbstractDao<Account> {

	public Account read(Integer id) {
		return this.read(id, new Account());
	}

	@Override
	public List<Account> readAll() {
		List<Account> accounts = new ArrayList<>();
		TypedQuery<Account> query = this.em.createQuery(JpqlQueries.SELECT_ACCOUNTS, Account.class);
		accounts.addAll(query.getResultList());
		return accounts;
	}


}

