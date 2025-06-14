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
	}
	
	 
	 /*
	 public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) {
	 // consultar si existe un cliente con el mismo dni, y si existe, arrojar la Excepcion
	 Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento);
	 return dao.agregar(c);
	 /*
	 private Long id;
	    private String nombre;
	    private Provincia provincia;
	 */
	 
	//public int agregar()

/*
	public Localidad traer(int id) {
		return dao.traer(id);
		
	}
*/
//	public List<Localidad> traer() {
		
		//return ClienteDao.getInstance().traer();
	//}


