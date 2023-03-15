package modelo.jpa;

import java.util.List;

import javax.persistence.Query;

import modelo.dao.ConcesionarioDAO;
import modelo.dao.PersonaDAO;
import modelo.entidades.Concesionario;
import modelo.entidades.Persona;

public class JPAConcesionarioDAO extends JPAGenericDAO<Concesionario, Integer> implements ConcesionarioDAO {

	public JPAConcesionarioDAO() {
		super(Concesionario.class);
	}

}
