package test;


import datos.Contacto;
import datos.Direccion;
import datos.Localidad;
import datos.Provincia;
import negocio.LocalidadAbm;
import negocio.ProvinciaAbm;
import negocio.ContactoAbm;
import negocio.DireccionAbm;

public class TestContacto {
	
	 public static void main(String[] args) {
		 
		     DireccionAbm direccionabm = new DireccionAbm();
		     ContactoAbm contactoabm = new ContactoAbm();
		     
		     //System.out.println(localidadabm.traer(1).toString());
			
			 try {
				 contactoabm.agregar("na_fer@hotmail", 14584565,54985656,9);
		            System.out.println("Contacto agregada con éxito.");
		        } catch (IllegalArgumentException e) {
		            System.err.println("No se pudo agregar Contacto: " + e.getMessage());
		        }
			 
			 
			 	
			System.out.println(contactoabm.traer(1));
			 //Usamos un for para traer todas las Localidad por consola
			 for(Contacto c: contactoabm.traer()) System.out.println(c);
			
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
	 
	 

