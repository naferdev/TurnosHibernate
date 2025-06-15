package test;


import java.util.Set;

import datos.Contacto;
import datos.Direccion;
import datos.Disponibilidad;
import datos.Especialidad;
import datos.Localidad;
import datos.Lugar;
import datos.Provincia;
import datos.Servicio;
import datos.Turno;
import datos.Persona;
import negocio.LocalidadAbm;
import negocio.PersonaAbm;
import negocio.ProvinciaAbm;
import negocio.ContactoAbm;
import negocio.DireccionAbm;

public class TestPersona {
	
	 public static void main(String[] args) {
		 
		     DireccionAbm direccionabm = new DireccionAbm();
		     ContactoAbm contactoabm = new ContactoAbm();
		     PersonaAbm personabm = new PersonaAbm();
		     //System.out.println(localidadabm.traer(1).toString());
			
			 try {
                             //String tipoPe, int dni, String nombre, long idContacto,String nroCliente, Set<Turno> lstTurnos,Integer matricula,Especialidad especialidad, Set<Disponibilidad> disponibilidades, Set<Servicio> servicios, Lugar lugar
				 personabm.agregar("cliente", 35923299, "marcos", null, "2656232", null, null, null, null, null, null);
				 System.out.println("Persona agregada con éxito.");
		        } catch (IllegalArgumentException e) {
		            System.err.println("No se pudo agregar Persona: " + e.getMessage());
		        }
			 
			 
			 
			System.out.println(personabm.traer(17));
			 //Usamos un for para traer todas las Personas por consola
			 for(Persona c: personabm.traer()) System.out.println(c);
			
			 try {
                 //String tipoPe, int dni, String nombre, long idContacto,String nroCliente, Set<Turno> lstTurnos,Integer matricula,Especialidad especialidad, Set<Disponibilidad> disponibilidades, Set<Servicio> servicios, Lugar lugar
				 	personabm.agregar("profesional", 35295656, "marcos", null, null, null, 12356, null, null, null, null);
				 		System.out.println("Persona agregada con éxito.");
			 	} catch (IllegalArgumentException e) {
			 		System.err.println("No se pudo agregar Persona: " + e.getMessage());
			 	}
			 
			 for(Persona c: personabm.traer()) System.out.println(c);
			 /*
	        Direccion direccionModificar = direccionabm.traerDireccionLocalidadYProvincia(2385);
			
			
			 System.out.printf("Direccion a Modificar: %s\n\n", direccionModificar);

				// modificar por set los atributos
			 direccionModificar.setCalle("Andrade");
			
				
			 // update del objeto
			 direccionabm.modificar(direccionModificar);
			
			 
			 System.out.printf("Localidad Modificada: %s\n\n", direccionabm.traerDireccionLocalidadYProvincia(2385));
			
			 System.out.printf("Localidad a Eliminar: %s\n\n",direccionabm.traerDireccionLocalidadYProvincia(2387));
			 Direccion direccionEliminar = direccionabm.traerDireccionLocalidadYProvincia(2387);
			 direccionabm.eliminar(direccionEliminar);
			 //Usamos un for para traer todas las Localidad por consola
			 for(Direccion c: direccionabm.traer()) System.out.println(c);
			 */
			 
			 
		    }
			
	 }
	 
	 

