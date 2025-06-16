package negocio;

import dao.ServicioDao;
import datos.Disponibilidad;
import datos.Servicio;

public class ServicioAbm {
	ServicioDao servicioDao = new ServicioDao();
	
	public Servicio traer(long id) {
 		 return servicioDao.traer(id);
 	 }
}
