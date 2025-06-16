package negocio;

import dao.DisponibilidadDao;
import dao.PersonaDao;
import datos.Disponibilidad;
import datos.Lugar;

public class DisponibilidadAbm {
	DisponibilidadDao disponibilidadDao = new DisponibilidadDao();
	PersonaDao personaDao = new PersonaDao();
	
	public Disponibilidad traer(long id) {
  		 return disponibilidadDao.traer(id);
  	 }
}
