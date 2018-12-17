package fr.formation.proxibanquev3.persistance;

import java.util.List;

/**
 * Definition d'une interface comportant les 4 méthodes elementaires de
 * manipulation de donnees CRUD + readALL.
 * @author Jessica Di Marco & Sandy Colin
 * @param <T> classe qui represente le type de donnees manipulé par le DAO.
 */
public interface Dao<T> {

	/**
	 * Lit les informations d'une entite de BDD
	 * 
	 * @param id l'identifiant d'une entite en base de donnees
	 * @return T l'entité construite à partir des informations récupérées
	 * 
	 */
	public T read(Integer id);

	/**
	 * Recupère toutes les entités (lignes) d'une table
	 * 
	 * @return List<T> la liste de toutes les entites lues.
	 */
	public List<T> readAll();

	/**
	 * met à jour l'entite donne dans la BDD
	 * 
	 * @param entity l'entite à mettre a jour avec les nouvelles informations
	 * @return l'entite mise à jour
	 */
	public T update(T entity);

	/**
	 * Crée une entite dans la BDD
	 * 
	 * @param entity l'entite à mettre a jour avec les nouvelles informations
	 * @return l'entite mise à jour
	 */
	public T create(T entity);

	/**
	 * supprime une entite donnée dans la BDD
	 * 
	 * @param id l'identifiant d'une entite en base de donnees
	 * @return un booléen vrai si la supression a lieu
	 */
	public boolean delete(Integer id);
}
