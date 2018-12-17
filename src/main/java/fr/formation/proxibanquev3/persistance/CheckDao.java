package fr.formation.proxibanquev3.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import fr.formation.proxibanquev3.metier.entity.Cheque;

/**
 * Classe regroupant les traitements � effectuer sur les chequiers. Respecte le
 * design pattern singleton.
 * 
 * @author  Jessica Di Marco & Sandy Colin
 *
 */
public class CheckDao extends AbstractDao<Cheque> {

	private static final CheckDao INSTANCE = new CheckDao();
	
	public static CheckDao getInstance() {
		return CheckDao.INSTANCE;
	}
	/**
	 * {@inheritDoc}
	 * Lit les informations d'un chéquier donné selon son id
	 */
	@Override
	public Cheque read(Integer id) {
		return this.read(id, new Cheque());
	}


	@Override
	/**
	 * {@inheritDoc}
	 * Récupère tous les chèquiers dans une liste
	 */
	public List<Cheque> readAll() {
		List<Cheque> checks = new ArrayList<>();
		TypedQuery<Cheque> query = this.em.createQuery(JpqlQueries.SELECT_ALL_CHECK, Cheque.class);
		checks.addAll(query.getResultList());
		return checks;
	}



}
