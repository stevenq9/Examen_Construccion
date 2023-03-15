package recurso;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import modelo.dao.DAOFactory;
import modelo.entidades.Auto;
import modelo.entidades.Persona;

@Path("/autos")
public class RecursoAuto {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Auto> getAutos() {
		return DAOFactory.getFactory().getAutoDAO().getAll();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{placa}")
	public Auto getAutoByPathParam(@PathParam("placa")String placa){
		return DAOFactory.getFactory().getAutoDAO().getById(placa);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/agregar")
	public boolean agregarAuto(Auto a){
		boolean crear = true;
		try {
			DAOFactory.getFactory().getAutoDAO().create(a);
		}catch(Exception e){
			crear = false;
		}
		return crear;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/actualizar")
	public boolean actualizarEstado(Auto a){
		boolean actualizar = true;
		try {
			DAOFactory.getFactory().getAutoDAO().update(a);
		}catch(Exception e){
			actualizar = false;
		}
		return actualizar;
	}
	
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{id}")
	public boolean eliminarAuto(@PathParam("placa")String placa){
		boolean eliminar = true;
		try {
			DAOFactory.getFactory().getAutoDAO().deleteById(placa);
		}catch(Exception e){
			eliminar = false;
		}
		return eliminar;
	}
	

}
