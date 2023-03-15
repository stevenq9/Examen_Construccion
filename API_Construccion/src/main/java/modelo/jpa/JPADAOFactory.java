package modelo.jpa;

import modelo.dao.AutoDAO;
import modelo.dao.ConcesionarioDAO;
import modelo.dao.DAOFactory;
import modelo.dao.PersonaDAO;

public class JPADAOFactory extends DAOFactory {

	@Override
	public PersonaDAO getPesonaDAO() {
		return new JPAPersonaDAO();
	}

	@Override
	public ConcesionarioDAO getConcesionarioDAO() {
		return new JPAConcesionarioDAO();
	}

	@Override
	public AutoDAO getAutoDAO() {
		return new JPAAutoDAO();
	}






}
