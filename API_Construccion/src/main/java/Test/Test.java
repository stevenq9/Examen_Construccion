package Test;


import modelo.dao.DAOFactory;
import modelo.entidades.Auto;
import modelo.entidades.Concesionario;
import modelo.entidades.Persona;

public class Test {
	public static void main(String[] args) {
		
		/** Creacion de Concesionario **/
		Concesionario c1 = new Concesionario();
		c1.setNombre("Kia");
		DAOFactory.getFactory().getConcesionarioDAO().create(c1);
		
		Concesionario c2 = new Concesionario();
		c2.setNombre("Mazda");
		DAOFactory.getFactory().getConcesionarioDAO().create(c2);
		
		
		 // CREACION DE PERSONAS 
		Persona nestor = new Persona();
		nestor.setNombre("Nestor");
		nestor.setCI(1753846952);
		DAOFactory.getFactory().getPesonaDAO().create(nestor);
		
		Persona pedro = new Persona();
		pedro.setNombre("Pedro");
		pedro.setCI(0201154446);
		DAOFactory.getFactory().getPesonaDAO().create(pedro);
		
		/** Creacion autos **/
		Auto a1 = new Auto();
		a1.setPlaca("PVX4563");
		a1.setEstado("DISPONIBLE");
		a1.setMarca("KIA");
		a1.setModelo("RIO");
		DAOFactory.getFactory().getAutoDAO().create(a1);
		
		Auto a2 = new Auto();
		a2.setPlaca("PCM7852");
		a2.setEstado("DISPONIBLE");
		a2.setMarca("MAZDA");
		a2.setModelo("3");
		DAOFactory.getFactory().getAutoDAO().create(a2);
		
		Auto a3 = new Auto();
		a3.setPlaca("PDE1230");
		a3.setEstado("DISPONIBLE");
		a3.setMarca("KIA");
		a3.setModelo("SOLUTO");
		DAOFactory.getFactory().getAutoDAO().create(a3);
		

		
	}
}
