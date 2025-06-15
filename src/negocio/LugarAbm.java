package negocio;

import java.sql.Time;
import java.util.List;

import dao.DireccionDao;
import dao.LocalidadDao;
import dao.LugarDao;
import dao.ProvinciaDao;
import datos.Direccion;
import datos.Localidad;
import datos.Lugar;
import datos.Provincia;

public class LugarAbm {
     LocalidadDao dao= new LocalidadDao();
     LugarDao lugarDao= new LugarDao();
     ProvinciaDao provinciaDao= new ProvinciaDao();
     DireccionDao direccionDao= new DireccionDao();
  

   	 public Lugar traer(long id) {
   		 return lugarDao.traer(id);
   	 }
   	 
   	 
   	 
   	 public long agregar(Time horarioApertura, Time horarioCierre, long idDireccion) {
   		 Direccion direccion =direccionDao.traer(idDireccion);
   		 
   		List<Lugar>lugares = lugarDao.existeDireccionConLugar(horarioApertura,idDireccion);
   		if (!lugares.isEmpty()) {
   		    throw new IllegalArgumentException("Ya existe un Lugar con esa dirección");
   		}
   		 
   	
   	    if (direccion == null) {
   	        System.err.println("Error: No existe Direccion con ID " );
   	        throw new IllegalArgumentException("Direccion no encontrada");
   	     
   	    }
  
   	    	Lugar c= new Lugar();
   	    	c.setDireccion(direccion);
   	    	c.setHorarioApertura(horarioApertura);
   	    	c.setHorarioCierre(horarioCierre);
   	    	c.setServicios(null);
   	    	return lugarDao.agregar(c);
   	       
   	    }
   	 
   	public List<Lugar> traer() {
		return lugarDao.traer();
		
	}
   	public Lugar traerLugarYdireccion(long idLugar) {
   		return lugarDao.traerLugarYDireccion(idLugar);
   	}
   
   	 public void modificar(Lugar c) {
   		lugarDao.actualizar(c);
   		}
   	public void eliminar(Lugar c) {
   		lugarDao.eliminar(c);
   	}
}
