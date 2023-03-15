package modelo.jpa;

import java.util.List;

import javax.persistence.Query;

import modelo.dao.AutoDAO;
import modelo.dao.PersonaDAO;
import modelo.entidades.Auto;
import modelo.entidades.Persona;

public class JPAAutoDAO extends JPAGenericDAO<Auto, String> implements AutoDAO {

	public JPAAutoDAO() {
		super(Auto.class);
	}
	
	@Override
	public List<Auto> getAll() {
		String sentenceJPQL = "SELECT a FROM Auto a";
		Query query = this.em.createQuery(sentenceJPQL);
		@SuppressWarnings("unchecked")
		List<Auto> autos = query.getResultList();
		return autos;
	}

}
