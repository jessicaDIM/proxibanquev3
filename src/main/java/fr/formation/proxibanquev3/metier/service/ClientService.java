package fr.formation.proxibanquev3.metier.service;

import java.util.List;

import fr.formation.proxibanquev3.metier.entity.Client;
import fr.formation.proxibanquev3.persistance.AccountDao;
import fr.formation.proxibanquev3.persistance.ClientDao;

/**
 * Classe regroupant les traitements à effectuer sur les clients. Respecte le
 * design pattern singleton.
 * 
 * @author Jessica Di Marco & Sandy Colin
 *
 */
public class ClientService {
	private static final ClientService INSTANCE = new ClientService(AccountDao.getInstance(), ClientDao.getInstance());
	private ClientDao daoClient;
	private AccountDao daoAccount;

	/**
	 * Retourne le singleton de la classe.
	 * 
	 * @return Le singleton.
	 */
	public static ClientService getInstance() {
		return ClientService.INSTANCE;
	}

	public ClientService() {
	}

	public ClientService(AccountDao daoAccount, ClientDao daoClient) {
		this.daoAccount = daoAccount;
		this.daoClient = daoClient;
	}

	/**
	 * Recupère la liste de tous les clients 
	 * 
	 * @return La liste des clients 
	 */
	public List<Client> getAll() {
		return this.daoClient.readAll();
	}

	
	

	/**
	 * Permet de récupérer un client à partir de son nom et prénom dans la Base De Données.
	 * 
	 * @param firstname, lastname Nom et prénom du client.
	 * @return Le client.
	 */

	public Client read(String firstname, String lastname) {
		return this.daoClient.readClientByName(firstname, lastname);

	}

	/**
	 * Permet de mettre � jour les informations d'un client. Cette m�thode g�re
	 * la modification du nom, du pr�nom, du mail et de l'adresse du client.
	 * 
	 * @param client L'id du client � actualiser.
	 */
	

	public void setDaoClient(ClientDao daoClient) {
		this.daoClient = daoClient;
	}

	public void setDaoAccount(AccountDao daoAccount) {
		this.daoAccount = daoAccount;
	}
	/**
	 * Permet de récupérer un client à partir de son id dans la Base De Données.
	 * 
	 * @param id L'id du client à récupérer.
	 * @return Le client.
	 */
	public Client read(Integer id) {
		return this.daoClient.read(id);
	}

}
