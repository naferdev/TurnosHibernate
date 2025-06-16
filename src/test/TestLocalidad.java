package test;


import datos.Localidad;
import datos.Provincia;
import negocio.LocalidadAbm;
import negocio.ProvinciaAbm;

public class TestLocalidad {
	
	 public static void main(String[] args) {
		 
		     LocalidadAbm localidadabm = new LocalidadAbm();
		     
		     System.out.println("AGREGAMOS LOCALIDADES ASOCIDAS A LOS IDS DE LAS PROVINCIAS PREVIAMENTE CREADAS");
			
			 try {
				   localidadabm.agregar("Burzaco",54);
		            System.out.println("Localidad agregada con éxito.");
		        } catch (IllegalArgumentException e) {
		            System.err.println("No se pudo agregar la Localidad: " + e.getMessage());
		        }
			 try {
				   localidadabm.agregar("Adrogue",56);
		            System.out.println("Localidad agregada con éxito.");
		        } catch (IllegalArgumentException e) {
		            System.err.println("No se pudo agregar la Localidad: " + e.getMessage());
		        }
			 
		     System.out.println("TRAEMOS LA LOCALIDAD Y PROVINCIAS CON SU ID");
				
			 Localidad localidadModificar = localidadabm.traerLocalidadyProvincia(2406);
			 
			 System.out.println(localidadabm.traerLocalidadyProvincia(2406));
			 //Usamos un for para traer todas las Localidad por consola
		     System.out.println("MOSTRAMOS UNA LISTA");
			 for(Localidad c: localidadabm.traer()) System.out.println(c);
			
		     System.out.println("MODIFICAMOS SU NOMBRE");
			 System.out.printf("Localidad a Modificar: %s\n\n", localidadModificar);

				// modificar por set los atributos
			 localidadModificar.setNombre("Lomaz de zamora");
				
			 // update del objeto
			localidadabm.modificar(localidadModificar);
			
			 System.out.printf("Localidad Modificada: %s\n\n", localidadabm.traerLocalidadyProvincia(2406));
			
			 System.out.printf("Localidad a Eliminar: %s\n\n",localidadabm.traerLocalidadyProvincia(2406));
			 Localidad localidaEliminar = localidadabm.traerLocalidadyProvincia(2406);
			 
			 localidadabm.eliminar(localidaEliminar);
			 //Usamos un for para traer todas las Localidad por consola
			 System.out.println("MOSTRAMOS LA LISTA LUEGO DE ELIMINAR\n");
			 for(Localidad c: localidadabm.traer()) System.out.println(c);
			
			 
			 
		    }
			
	 }
	 
	 

