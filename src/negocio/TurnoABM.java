package negocio;

import dao.DisponibilidadDao;
import dao.LugarDao;
import dao.PersonaDao;
import dao.ServicioDao;
import dao.TurnoDao;
import datos.Disponibilidad;
import datos.Lugar;
import datos.Persona;
import datos.Servicio;
import datos.Turno;

public class TurnoABM {
	TurnoDao turnoDao = new TurnoDao();
	PersonaDao personaDao = new PersonaDao();
	DisponibilidadDao disponibilidadDao = new DisponibilidadDao();
	ServicioDao servicioDao = new ServicioDao();
	LugarDao lugarDao = new LugarDao();
	
	public long Agregar (long idCliente, long idProfesional, long idDisponibilidad, long idServicio, long idLugar) {
		
		Persona cliente = personaDao.traer(idCliente);
		Persona profesional = personaDao.traer(idProfesional);
		Disponibilidad disponibilidad = disponibilidadDao.traer(idDisponibilidad);
		Servicio servicio = servicioDao.traer(idServicio);
		Lugar lugar = lugarDao.traer(idLugar);
		
		if (disponibilidad.getOcupado() == true) {
   	        System.err.println("Error: El turno ya se encuentra ocupado " );
   	        throw new IllegalArgumentException("Turno ocupado");
   	     
   	    }
		
		Turno t= new Turno();
	    	t.setCliente(cliente);
	    	t.setProfesional(profesional);
	    	t.setDisponibilidad(disponibilidad);
	    	t.setServicio(servicio);
	    	t.setLugar(lugar);
	    	return turnoDao.agregar(t);
	}
	
	public Turno traer(long id) {
  		 return turnoDao.traer(id);
  	 }
	
	public void modificar(Turno c) {
		turnoDao.actualizar(c);
   		}
   	public void eliminar(Turno c) {
   		turnoDao.eliminar(c);
   	}
   	
   	public Turno traerTurnoCompleto(long idTurno) {
   		return turnoDao.traerTurnoCompleto(idTurno);
   	}
}
