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
import datos.Profesional;
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
		 
		     System.out.println("Agregamos Personas a la base de datos, utilizamos el discriminador para marcar la herencia , Puede ser 'CLIENTE' o 'PROFESIONAL'");
		     System.out.println("Cabe mencionar que para poder verificar esto seteamos que el campo de contacto pueda ser null");
			 try {
       //String tipoPe, int dni, String nombre, long idContacto,String nroCliente, Set<Turno> lstTurnos,Integer matricula,Especialidad especialidad, Set<Disponibilidad> disponibilidades, Set<Servicio> servicios, Lugar lugar
				//
				 personabm.agregar("cliente", 1756566, "Roberto", null, "152356", null, null, null, null, null, null);
				
				 System.out.println("Persona agregada con éxito.");
				 
		        } catch (IllegalArgumentException e) {
		            System.err.println("No se pudo agregar Persona: " + e.getMessage());
		        }
			 
			 System.out.println("Mostramos la lista de Personas, dicriminando si son clientes o profesionales");
			 //Usamos un for para traer todas las Personas por consola
			 for(Persona c: personabm.traer()) System.out.println(c);
			
			 System.out.println("Agregamos a un Profesional"); 
			 try {
                 //String tipoPe, int dni, String nombre, long idContacto,String nroCliente, Set<Turno> lstTurnos,Integer matricula,Especialidad especialidad, Set<Disponibilidad> disponibilidades, Set<Servicio> servicios, Lugar lugar
				 	personabm.agregar("profesional", 35295623, "RAUL", null, null, null, 156303, null, null, null, null);
				 		System.out.println("Persona agregada con éxito.");
			 	} catch (IllegalArgumentException e) {
			 		System.err.println("No se pudo agregar Persona: " + e.getMessage());
			 	}
			 System.out.println("Agregamos a un Profesional"); 
			 try {
                 //String tipoPe, int dni, String nombre, long idContacto,String nroCliente, Set<Turno> lstTurnos,Integer matricula,Especialidad especialidad, Set<Disponibilidad> disponibilidades, Set<Servicio> servicios, Lugar lugar
				 	personabm.agregar("profesional", 17233623, "Marcos Solis", null, null, null, 10900, null, null, null, null);
				 		System.out.println("Persona agregada con éxito.");
			 	} catch (IllegalArgumentException e) {
			 		System.err.println("No se pudo agregar Persona: " + e.getMessage());
			 	}
			 
			 System.out.println("Mostramos la lista de Personas, dicriminando si son clientes o profesionales");
			 for(Persona c: personabm.traer()) System.out.println(c);
			 
			  System.out.printf("\n\nBUSCAMOS UNA PERSONA POR SU MATRICULA \n");
			  Persona personaMatricula =personabm.traerXmatricula(10900);
			  Profesional profMatricula= (Profesional) personaMatricula;
			  
			  System.out.printf("\n\nAGREGAMOS A LA PERSONA QUE BUSCABAMOS POR MATRICULA UN CONTACTO\n");
			  personabm.agregarContactoPersona(personaMatricula, "na_fernandez", 15465623, 1546562, 20);
			  
			  System.out.printf("\nMatricula : %d   ",profMatricula.getMatricula());
			  System.out.printf("Persona : %s\n", personaMatricula);
			
			  
	        Persona personaModificar = personabm.traerXdni(35295623);
			
	        System.out.printf("\n\nBUSCAMOS UNA PERSONA POR SU DNI Y LUEGO MODIFICAMOS SU NOMBRE\n");
			 System.out.printf("Persona a Modificar: %s\n\n", personaModificar);

				// modificar por set los atributos
			 personaModificar.setNombre("Roberto");	
			 // update del objeto
			 personabm.modificar(personaModificar);
		
			 System.out.printf("Persona Modificada: %s\n\n", personabm.traerXdni(35295623));
			 
			 
			 System.out.printf("\n\nBUSCAMOS UNA PERSONA POR SU DNI Y LUEGO LA ELIMINAMOS\n");
			 System.out.printf("Persona  a Eliminar: %s\n\n",personabm.traerXdni(35295623));
			 Persona personaEliminar = personabm.traerXdni(35295623);
			 personabm.eliminar(personaEliminar);
			 System.out.printf("\nMOSTRAMOS LA LISTA DE TODAS LAS PERSONAS CLIENTES Y PROFESIONALES\n");
			 //Usamos un for para traer todas las Localidad por consola
			 for(Persona c: personabm.traer()) System.out.println(c);
			 
		
		    }
			
	 }
	 
	 

