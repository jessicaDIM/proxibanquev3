package fr.formation.proxibanquev3.persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe permettant de se lier a� la base de donnees MySQL. 
 * Cette classe est un singleton.
 * @author Adminl
 *
 */
public class MySqlConnection {

	public static final MySqlConnection INSTANCE = new MySqlConnection();

	public static MySqlConnection getInstance() {
		return MySqlConnection.INSTANCE;
	}

	private EntityManagerFactory entityManagerFactory;
	
	public MySqlConnection() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("proxibanquev3");
	}
	
	public EntityManager getEntityManager() {
		return this.entityManagerFactory.createEntityManager();
	}

}