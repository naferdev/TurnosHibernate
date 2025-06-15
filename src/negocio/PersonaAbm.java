package negocio;

import java.util.List;
import java.util.Set;

import dao.ContactoDao;
import dao.DireccionDao;
import dao.LocalidadDao;
import dao.PersonaDao;
import dao.ProvinciaDao;
import datos.Cliente;
import datos.Contacto;
import datos.Direccion;
import datos.Disponibilidad;
import datos.Especialidad;
import datos.Localidad;
import datos.Lugar;
import datos.Persona;
import datos.Profesional;
import datos.Provincia;
import datos.Servicio;
import datos.Turno;

public class PersonaAbm {
     LocalidadDao dao= new LocalidadDao();
     ProvinciaDao provinciaDao= new ProvinciaDao();
     DireccionDao direccionDao= new DireccionDao();
     ContactoDao contactoDao= new ContactoDao();
     PersonaDao personaDao = new PersonaDao();

   	 public Persona traer(long id) {
   		 return personaDao.traer(id);
   	 }
   	 
   	 public long agregar(String tipoPersona, int dni, String nombre, Long idContacto,String nroCliente,
 			Set<Turno> lstTurnos,Integer matricula,Especialidad especialidad, Set<Disponibilidad> disponibilidades, Set<Servicio> servicios, Lugar lugar) {
   		
   		Contacto contacto = null;
   	    if (idContacto != null) {
   	        contacto = contactoDao.traer(idContacto);
   	    
   	        if (contacto == null) {
   	            throw new IllegalArgumentException("Contacto no encontrado con ID: " + idContacto);
   	        }
   	    }

   	    if (!personaDao.existePersona(dni).isEmpty()) {
   	        throw new IllegalArgumentException("Ya existe una Persona con ese DNI: " + dni);
   	    }
   	 
   	 	Persona persona;
   	 	switch (tipoPersona.toLowerCase()) {
         case "cliente":
             Cliente cli = new Cliente();
             cli.setContacto(contacto);
             cli.setDni(dni);
             cli.setNombre(nombre);
             cli.setTipoPersona("cliente");
             cli.setNroCliente(nroCliente);
             cli.setLstTurnos(lstTurnos);
             persona =cli;
             break;
         case "profesional":
             Profesional pro = new Profesional();
             pro.setContacto(contacto);
             pro.setDisponibilidades(disponibilidades);
             pro.setDni(dni);
             pro.setEspecialidad(especialidad);
             pro.setLugar(lugar);
             pro.setNombre(nombre);
             pro.setMatricula(matricula);
             pro.setServicios(servicios);
             pro.setTipoPersona("profesional");
             persona=pro;
             break;
         default:
             throw new IllegalArgumentException("Tipo de persona no válido: " + tipoPersona);
     }

   	        return personaDao.agregar(persona);
   	        
   	    }
   	 
   	public List<Persona> traer() {
		return personaDao.traer();
		
	}
   	
   	
   	/*
   	public Contacto traerDireccionLocalidadYProvincia(long idLocalidad) {
   		return direccionDao.traerDireccionLocalidadYProvincia(idLocalidad);
   	}
   	*/
   	public Localidad traerLocalidadyProvincia(long id) {
   		return dao.traerLocalidadYProvincia(id);
   	}
   	
   	 public void modificar(Persona c) {
   		personaDao.actualizar(c);
   		}
   	public void eliminar(Persona c) {
   		personaDao.eliminar(c);
   	}
}
