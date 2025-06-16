package test;


import datos.Direccion;
import datos.Localidad;
import datos.Provincia;
import negocio.LocalidadAbm;
import negocio.ProvinciaAbm;
import negocio.DireccionAbm;

public class TestDireccion {
	
	 public static void main(String[] args) {
		 
		     DireccionAbm direccionabm = new DireccionAbm();
		     
		 
		
			 try {
			
				 direccionabm.agregar(550,"Mar del Plata",2387);
				 System.out.println("AGREGAMOS UNA DIRECCION \n");
				 
		            System.out.println("Direccion agregada con éxito.");
		        } catch (IllegalArgumentException e) {
		            System.err.println("No se pudo agregar la Direccion: " + e.getMessage());
		        }
			 
			 
			 System.out.println("TRAEMOS UNA DIRECCION CON SU LOCALIDAD Y PROVINCIA BUSCADA POR ID \n"); 	
			System.out.println(direccionabm.traerDireccionLocalidadYProvincia(2383));
			
			//Usamos un for para traer todas las Localidad por consola
			 System.out.println("\nMOSTRAMOS UNA LISTA DE TODAS LAS DIRECCIONES CREADAS"); 
			for(Direccion c: direccionabm.traer()) System.out.println(c);
			
	        Direccion direccionModificar = direccionabm.traerDireccionLocalidadYProvincia(2385);
			
			
			 System.out.printf("Direccion a Modificar: %s\n\n", direccionModificar);

				// modificar por set los atributos
			 direccionModificar.setCalle("Andrade");
			
				
			 // update del objeto
			 direccionabm.modificar(direccionModificar);
			
			 
			 System.out.printf("Direccion Modificada se cambia el nombre: %s\n\n", direccionabm.traerDireccionLocalidadYProvincia(2385));
			
			 System.out.printf("Direccion a Eliminar: %s\n\n",direccionabm.traerDireccionLocalidadYProvincia(2387));
			 Direccion direccionEliminar = direccionabm.traerDireccionLocalidadYProvincia(2387);
			 direccionabm.eliminar(direccionEliminar);
			 //Usamos un for para traer todas las Localidad por consola
			 System.out.println("\nMOSTRAMOS LA LISTA LUEGO DE ELIMINAR"); 
			 for(Direccion c: direccionabm.traer()) System.out.println(c);
			 
			 
			 
		    }
			
	 }
	 
	 

