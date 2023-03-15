package modelo.jpa;

import java.util.List;

import javax.persistence.Query;

import modelo.dao.PersonaDAO;
import modelo.entidades.Persona;

public class JPAPersonaDAO extends JPAGenericDAO<Persona, Integer> implements PersonaDAO {

	public JPAPersonaDAO() {
		super(Persona.class);
	}

	@Override
	public List<Persona> getAll() {
		String sentenceJPQL = "SELECT p FROM Persona p";
		Query query = this.em.createQuery(sentenceJPQL);
		@SuppressWarnings("unchecked")
		List<Persona> personas = query.getResultList();
		return personas;
	}

}
