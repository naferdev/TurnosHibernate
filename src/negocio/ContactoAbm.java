package negocio;

import java.util.List;

import dao.ContactoDao;
import dao.DireccionDao;
import dao.LocalidadDao;
import dao.PersonaDao;
import dao.ProvinciaDao;
import datos.Contacto;
import datos.Direccion;
import datos.Localidad;
import datos.Persona;
import datos.Provincia;

public class ContactoAbm {
     LocalidadDao dao= new LocalidadDao();
     ProvinciaDao provinciaDao= new ProvinciaDao();
     DireccionDao direccionDao= new DireccionDao();
     ContactoDao contactoDao= new ContactoDao();
     PersonaDao personaDao= new PersonaDao();
  

   	 public Contacto traer(long id) {
   		 return contactoDao.traer(id);
   	 }
   	 
   	 
   	 
   	 public Contacto agregar(String email, Integer movil, Integer telefono, long idDireccion) {
   		Direccion direccion = direccionDao.traer(idDireccion); // Busca la direccion x id
   	
   	
   	    if (direccion == null) {
   	        System.err.println("Error: No existe Direccion con ID " + idDireccion);
   	        throw new IllegalArgumentException("Direccion no no encontrada");
   	     
   	    }
   	    List<Contacto> contactos = contactoDao.existeConctacoMail(email);
   	 	if (!contactos.isEmpty()) {
     	//Verifica si ya existe una provincia con ese nombre o duplicado
         System.err.println("Error: Ya existe un Contacto con el mail: " + email);
         //Imprime el errro por consola en rojo
         throw new IllegalArgumentException("Ya existe un Contacto con el mail: " + email);
         //crea la exepcion;
      }
  

   	        Contacto c = new Contacto();
   	        c.setDireccion(direccion);
   	        c.setEmail(email);
   	        c.setMovil(movil);
   	        c.setTelefono(telefono);
   
   	       
   	        
   	        return c;
   	        
   	    }
   	 
   	public List<Contacto> traer() {
		return contactoDao.traer();
		
	}
  
 
   	
   	 public void modificar(Contacto c) {
   		contactoDao.actualizar(c);
   		}
   	public void eliminar(Contacto c) {
   		contactoDao.eliminar(c);
   	}
}
