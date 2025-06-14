package negocio;

import java.util.List;

import dao.ProvinciaDao;
import dao.LocalidadDao;
import datos.Cliente;
import datos.Localidad;
import datos.Provincia;

public class ProvinciaAbm {
	
     ProvinciaDao dao= new ProvinciaDao();

	 public Provincia traer(long id) {
		 return dao.traer(id);
	 }
	 
	 public long agregar(String nombre) {
	        if (dao.existeProvinciaConNombre(nombre)!=null) {
	        	//Verifica si ya existe una provincia con ese nombre o duplicado
	            System.err.println("Error: Ya existe una provincia con el nombre: " + nombre);
	            //Imprime el errro por consola en rojo
	            throw new IllegalArgumentException("Ya existe una provincia con el nombre: " + nombre);
	            //crea la exepcion;
	        }

	        Provincia c = new Provincia();
	        c.setNombre(nombre);
	        return dao.agregar(c);
	    }
	
	 public void modificar(Provincia c) {
			dao.actualizar(c);
		}
	public void eliminar(Provincia c) {
		dao.eliminar(c);
	}

	public List<Provincia> traer() {
		return dao.traer();
		
	}
}
	



