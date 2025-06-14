package negocio;

import java.util.List;


import dao.LocalidadDao;
import dao.ProvinciaDao;
import datos.Localidad;
import datos.Provincia;

public class LocalidadAbm {
     LocalidadDao dao= new LocalidadDao();
     ProvinciaDao provinciaDao= new ProvinciaDao();
  

   	 public Localidad traer(long id) {
   		 return dao.traer(id);
   	 }
   	 
   	 public long agregar(String nombre, long idProvincia) {
   		Provincia provincia = provinciaDao.traer(idProvincia); // buscás la provincia por ID

   	    if (provincia == null) {
   	        System.err.println("Error: No existe provincia con ID " + idProvincia);
   	        throw new IllegalArgumentException("Provincia no encontrada");
   	     
   	    }
   	   if (dao.existeLocalidadConNombre(nombre)!=null) {
     	//Verifica si ya existe una provincia con ese nombre o duplicado
         System.err.println("Error: Ya existe una Localidad con el nombre: " + nombre);
         //Imprime el errro por consola en rojo
         throw new IllegalArgumentException("Ya existe una provincia con el nombre: " + nombre);
         //crea la exepcion;
      }
  

   	        Localidad c = new Localidad();
   	        c.setNombre(nombre);
   	        c.setProvincia(provincia);
   	        return dao.agregar(c);
   	    }
   	 
   	public List<Localidad> traer() {
		return dao.traer();
		
	}
   	public Localidad traerLocalidadyProvincia(long id) {
   		return dao.traerLocalidadYProvincia(id);
   	}
   	
   	 public void modificar(Localidad c) {
   			dao.actualizar(c);
   		}
   	public void eliminar(Localidad c) {
   		dao.eliminar(c);
   	}
}
