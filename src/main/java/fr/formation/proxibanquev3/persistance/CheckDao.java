package fr.formation.proxibanquev3.persistance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import fr.formation.proxibanquev3.metier.entity.Check;

/**
 * Classe regroupant les traitements � effectuer sur les chequiers. Respecte le
 * design pattern singleton.
 * 
 * @author Adminl
 *
 */
public class CheckDao extends AbstractDao<Check> {

	private static final CheckDao INSTANCE = new CheckDao();
	
	public static CheckDao getInstance() {
		return CheckDao.INSTANCE;
	}

	@Override
	public Check read(Integer id) {
		return this.read(id, new Check());
	}


	@Override
	public List<Check> readAll() {
		List<Check> checks = new ArrayList<>();
		TypedQuery<Check> query = this.em.createQuery(JpqlQueries.SELECT_ALL_CHECK, Check.class);
		checks.addAll(query.getResultList());
		return checks;
	}



}
