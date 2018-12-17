package fr.formation.proxibanquev3.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import fr.formation.proxibanquev3.metier.entity.Client;

/**
 * Classe regroupant les traitements � effectuer sur les clients. Respecte le
 * design pattern singleton.
 * 
 * @author Adminl
 *
 */
public class ClientDao extends AbstractDao<Client> {

	private static final ClientDao INSTANCE = new ClientDao();
	
	public static ClientDao getInstance() {
		return ClientDao.INSTANCE;
	}

	@Override
	public Client read(Integer id) {
		return this.read(id, new Client());
	}


	@Override
	public List<Client> readAll() {
		List<Client> clients = new ArrayList<>();
		TypedQuery<Client> query = this.em.createQuery(JpqlQueries.SELECT_ALL_CLIENTS, Client.class);
		
		clients.addAll(query.getResultList());
		return clients;
	}
	
	public Client readClientByName(String firstname, String lastname) {
		Client client=null;
		TypedQuery<Client> query = this.em.createQuery(JpqlQueries.SELECT_CLIENT_BY_NAME, Client.class);
		try {
		client= query.setParameter("firstname", firstname).setParameter("lastname", lastname).getSingleResult();
		}
		catch(NoResultException | NonUniqueResultException e) {
			System.out.println("Soit il n'y a pas de résultat, soit il y en a plus d'un");
		}
		
		return client;
	}
	 
}