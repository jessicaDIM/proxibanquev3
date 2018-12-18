package fr.formation.proxibanquev3.metier.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.formation.proxibanquev3.metier.entity.Account;
import fr.formation.proxibanquev3.metier.entity.Cheque;
import fr.formation.proxibanquev3.metier.entity.Client;
import fr.formation.proxibanquev3.metier.entity.CreditCard;
import fr.formation.proxibanquev3.metier.entity.CurrentAccount;
import fr.formation.proxibanquev3.metier.entity.SavingsAccount;
import fr.formation.proxibanquev3.persistance.AccountDao;
import fr.formation.proxibanquev3.persistance.CheckDao;
import fr.formation.proxibanquev3.persistance.ClientDao;
import fr.formation.proxibanquev3.persistance.CreditCardDao;
/**
 * Classe regroupant les traitements à effectuer sur les ccomptes. Respecte le
 * design pattern singleton.
 * 
 * @author Jessica Di Marco & Sandy Colin
 *
 */
public class AccountService {

	private static final AccountService INSTANCE = new AccountService();
	private AccountDao accountDao;
	private ClientDao clientDao;
	private CreditCardDao cardDao;
	private CheckDao chequeDao;
	
	public AccountService() {
		this.accountDao = AccountDao.getInstance();
		this.clientDao = ClientDao.getInstance();
		this.cardDao = CreditCardDao.getInstance();
		this.chequeDao = CheckDao.getInstance();
	}

	/**
	 * Retourne le singleton de la classe.
	 * 
	 * @return Le singleton.
	 */
	public static AccountService getInstance() {
		return AccountService.INSTANCE;
	}

	/**
	 * Recupère la liste de tous les comptes associés à un client.
	 * 
	 * @param idClient L'id du client dont on veut les comptes.
	 * @return La liste des comptes du client.
	 */
	public List<Account> getAll(Integer idClient) {
		List<Account> accounts = new ArrayList<>();

		accounts = this.clientDao.read(idClient).getAccounts();

		return accounts;

	}

	/**
	 * Recupère la liste des comptes épargne d'un client.
	 * 
	 * @param idClient L'id du client dont on veut les comptes épargne.
	 * @return La liste des comptes épargne du client.
	 */
	public List<Account> getAllSavingAccounts(Integer idClient) {
		List<Account> SavingAccounts = new ArrayList<>();

		List<Account> accounts = new ArrayList<>();
		accounts = this.clientDao.read(idClient).getAccounts();

		for (Account account : accounts) {
			if (account instanceof SavingsAccount) {
				SavingAccounts.add(account);
			}
		}
		return SavingAccounts;
	}

	/**
	 * Recupère la liste des comptes courant d'un client.
	 * 
	 * @param idClient L'id du client dont on veut les comptes courant.
	 * @return La liste des comptes courant du client.
	 */
	public List<Account> getAllCurrentAccounts(Integer idClient) {
		List<Account> CurrentAccounts = new ArrayList<>();

		List<Account> accounts = new ArrayList<>();
		accounts = this.clientDao.read(idClient).getAccounts();

		for (Account account : accounts) {
			if (account instanceof CurrentAccount) {
				CurrentAccounts.add(account);
			}
		}
		return CurrentAccounts;
	}

	public AccountDao getDao() {
		return this.accountDao;
	}
	
	/**
	 * Permet de faire un virement entre deux comptes d'un même client si le solde est suffisant
	 * 
	 * @param value         Le montant du virement à effectuer.
	 * @param compteDebite  Le compte à débiter.
	 * @param compteCredite Le compte à créditer
	 * @return False si le virement rend le compte débité en solde
	 *         négatif. True sinon.
	 */
	public boolean transfer(Float value, Integer debitId, Integer creditId,
			Integer clientId) {
		boolean transferOK = true;
		Client client = this.clientDao.read(clientId);
		Account compteDebite = client.getAccountById(debitId);
		Account compteCredite = client.getAccountById(creditId);
		if (compteDebite.getId() == compteCredite.getId()) {
			transferOK=false;
			return transferOK;
		} else if (compteDebite.getBalance() - value < 0) {
			transferOK = false;
			return transferOK;
		}
			else if(value>900) {
				transferOK = false;
				return transferOK;
			
		} else {
			compteCredite.setBalance(compteCredite.getBalance() + value);
			this.accountDao.update(compteCredite);

			compteDebite.setBalance(compteDebite.getBalance() - value);
			this.accountDao.update(compteDebite);

			return transferOK;
		}
	}
	
	
	/**
	 * Permet de faire un retrait sur le compte d'un client si le solde est suffisant
	 * @param value montant du retrait à effectuer.
	 * @param accountId le compte à débiter.
	 * @return False si le retrait rend le compte débité en solde
	 *         négatif. True sinon.
	 */
	public boolean withdrawCash(Float value, Integer accountId) {
		//Verifier compte courant
		boolean withdrawOK = true;
		Account compteDebite = this.accountDao.read(accountId);
		if (value>300.00) {
			withdrawOK=false;
			return withdrawOK;
		} else if (compteDebite.getBalance() - value < 0) {
			withdrawOK = false;
			return withdrawOK;
		} else {
			compteDebite.setBalance(compteDebite.getBalance() - value);
			this.accountDao.update(compteDebite);
			return withdrawOK;
		}
		
	}/**
	 * Permet de faire un retrait de chéquier sous conditions de date
	 * @param accountId le compte à débiter.
	 * @return False si le retrait n'est pas possible (date dernier chéquier inférieur à 3 mois). True sinon.
	 */
	public boolean withdrawCheck(Integer accountId) {
		
		boolean resultOk = true;
		Account account = this.accountDao.read(accountId);
		
		// Si le compte avait déjà un chéquier.
		if (account.getCheque() != null) {
			// On vérifie que la date de reception du précédent est bien de plus de 3 mois
			if(account.getCheque().getReceptionDate().isBefore(LocalDate.now().minusMonths(3))) {
				Integer checkId= account.getCheque().getId();
				// Retirer le lien entre l'ancien chéquier et le compte.
				account.setCheque(null);
				// Mettre à jour le compte pour que le lien n'existe plus en BDD.
				this.accountDao.update(account);
				this.chequeDao.delete(checkId);
			} else {
				// Sinon on indique qu'il ne faut pas créer de carte.
				resultOk = false;
			}
		}
		// Si il est possible d'ajouter un chéquier.
		if (resultOk) {
			// On prepare la nouvelle carte.
			Cheque newCheque = new Cheque();
			//newCard.setExpirationDate(LocalDate.now().plusMonths(3));
			//newCard.setType(type);
			// On créé la carte en BDD pour avoir un id généré.
			newCheque = this.chequeDao.create(newCheque);
			// On lie le nouveau chéquier au compte.
			account.setCheque(newCheque);
			// On met à jour le compte avec le lien vers la nouvelle carte.
			this.accountDao.update(account);
		}
		return resultOk;
		
	}
	/**
	 * Permet de faire un retrait de carte bancaire si l'ancienne a atteint sa date d'expiration
	 * 
	 * @return False si le retrait n'est pas possible (carte tjs valide). True sinon.
	 */
	public boolean withdrawCard(Integer accountId, String type) {
		
		boolean resultOk = true;
		//Account account = this.accountDao.read(accountId);
		CurrentAccount currentAccount= (CurrentAccount) this.accountDao.read(accountId);
		// Si le compte avait déjà une carte et qu'elle a expirée.
		if (currentAccount.getCard() != null) {
			// On vérifie que la date d'expiration est bien dépassée.
			if (currentAccount.getCard().getExpirationDate().isBefore(LocalDate.now())) {
				Integer cardId= currentAccount.getCard().getId();
				// Retirer le lien entre l'ancienne carte et le compte.
				currentAccount.setCard(null);
				// Mettre à jour le compte pour que le lien n'existe plus en BDD.
				this.accountDao.update(currentAccount);	
				this.cardDao.delete(cardId);
			} else { // « Impossible d’effectuer le retrait, votre ancienne carte est encore valide »
				// Sinon on indique qu'il ne faut pas créer de carte.
				resultOk = false;
			}
		}
		// Si il est possible d'ajouter une carte.
		if (resultOk) {
			// On prepare la nouvelle carte.
			CreditCard newCard = new CreditCard();
			newCard.setExpirationDate(LocalDate.now().plusYears(3));
			newCard.setType(type);
			// On créé la carte en BDD pour avoir un id généré.
			newCard = this.cardDao.create(newCard);
			// On lie la nouvelle carte au compte.
			currentAccount.setCard(newCard);
			// On met à jour le compte avec le lien vers la nouvelle carte.
			this.accountDao.update(currentAccount);
		}
		return resultOk;
	}
		
		
	
	/**
	 * Met à jour le compte
	 * @return un objet AccountService
	 */

}
