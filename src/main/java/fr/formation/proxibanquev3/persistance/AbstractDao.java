package fr.formation.proxibanquev3.persistance;

import javax.persistence.EntityManager;
/**
 * 
 * @author  Jessica Di Marco & Sandy Colin
 *
 * @param <T> classe qui represente le type de donnees manipulé par le DAO.
 */
public abstract class AbstractDao<T> implements Dao<T>{
	
	protected EntityManager em;
	
	public AbstractDao() {
		this.em = MySqlConnection.getInstance().getEntityManager();
	}
	
	/**
	 * {@inheritDoc}
	 * Crée un objet T
	 */
	@Override
	public T create(T entity) {
		this.em.getTransaction().begin();
		this.em.persist(entity);
		this.em.getTransaction().commit();
		return entity;
	}
	/**
	 * {@inheritDoc}
	 * Met à jour un objet T
	 */
	@Override
	public T update(T entity) {
		this.em.getTransaction().begin();
		this.em.merge(entity);
		this.em.getTransaction().commit();
		return entity;
	}
	/**
	 * {@inheritDoc}
	 * Lit une ligne selon l'entité
	 */
	@SuppressWarnings("unchecked")
	protected T read(Integer id, T entity) {
		T result = null;
		result = (T) this.em.find(entity.getClass(), id);
		return result;
	}

	/**
	 * {@inheritDoc}
	 * Supprime une ligne selon l'id
	 */
	@Override
	public boolean delete(Integer id) {
		this.em.getTransaction().begin();
		T entity = this.read(id);
		this.em.remove(entity);
		this.em.getTransaction().commit();
		return true;
	}
	
	
}