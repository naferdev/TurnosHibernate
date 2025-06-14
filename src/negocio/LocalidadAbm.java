package negocio;

import java.util.List;


import dao.LocalidadDao;
import datos.Cliente;
import datos.Localidad;
import datos.Provincia;

public class LocalidadAbm {
	private static LocalidadAbm instancia = null; // Patrón Singleton
     LocalidadDao dao= new LocalidadDao();

	 //public Cliente traer(long idCliente) {
		 //return dao.traer(idCliente);
	 //}
	 
	 
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


	public Localidad traer(int id) {
		return dao.traer(id);
		
	}

//	public List<Localidad> traer() {
		
		//return ClienteDao.getInstance().traer();
	//}

}
