package fr.formation.proxibanquev3.persistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe permettant de se lier à la base de donnees MySQL. 
 * Cette classe est un singleton.
 * @author Jessica Di Marco & Sandy Colin
 *
 */
public class MySqlConnection {

	public static final MySqlConnection INSTANCE = new MySqlConnection();
	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;

	public static MySqlConnection getInstance() {
		return MySqlConnection.INSTANCE;
	}
	
	/**
	 * Constructeur par défaut. Récupère l'instance d'EntityManagerFactory associée à notre unité de persistance "proxibanquev3" défini dans persistance.xml.
	 */
	
	public MySqlConnection() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("proxibanquev3");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	/**
	 * 
	 * @return EntityManager une instance capable d'effectuer les opérations CRUD sur la base de données.
	 */
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

}