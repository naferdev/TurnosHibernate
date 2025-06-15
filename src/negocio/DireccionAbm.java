package negocio;

import java.util.List;

import dao.DireccionDao;
import dao.LocalidadDao;
import dao.ProvinciaDao;
import datos.Direccion;
import datos.Localidad;
import datos.Provincia;

public class DireccionAbm {
     LocalidadDao dao= new LocalidadDao();
     ProvinciaDao provinciaDao= new ProvinciaDao();
     DireccionDao direccionDao= new DireccionDao();
  

   	 public Direccion traer(long id) {
   		 return direccionDao.traer(id);
   	 }
   	 
   	 public long agregar(Integer altura, String calle, long idLocalidad) {
   		Localidad localidad = dao.traerLocalidadYProvincia(idLocalidad); // buscás la provincia por ID
   	
   	    if (localidad == null) {
   	        System.err.println("Error: No existe Localidad con ID " + idLocalidad);
   	        throw new IllegalArgumentException("Provincia no encontrada");
   	     
   	    }
   	    List<Direccion> direcciones = direccionDao.existeDireccionConNombre(calle, altura);
   	 	if (!direcciones.isEmpty()) {
     	//Verifica si ya existe una provincia con ese nombre o duplicado
         System.err.println("Error: Ya existe una Direccion con el nombre: " + calle);
         //Imprime el errro por consola en rojo
         throw new IllegalArgumentException("Ya existe una direccion con el nombre: " + calle);
         //crea la exepcion;
      }
  

   	        Direccion c = new Direccion();
   	        c.setCalle(calle);
   	        c.setLocalidad(localidad);
   	        c.setProvincia(localidad.getProvincia());
   	        c.setAltura(altura);
   	        return direccionDao.agregar(c);
   	    }
   	 
   	public List<Direccion> traer() {
		return direccionDao.traer();
		
	}
   	public Direccion traerDireccionLocalidadYProvincia(long idLocalidad) {
   		return direccionDao.traerDireccionLocalidadYProvincia(idLocalidad);
   	}
   	public Localidad traerLocalidadyProvincia(long id) {
   		return dao.traerLocalidadYProvincia(id);
   	}
   	
   	 public void modificar(Direccion c) {
   		direccionDao.actualizar(c);
   		}
   	public void eliminar(Direccion c) {
   		direccionDao.eliminar(c);
   	}
}
