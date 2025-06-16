package test;



import datos.Provincia;
import negocio.LocalidadAbm;
import negocio.ProvinciaAbm;

public class TestProvincia {
	
	 public static void main(String[] args) {
		     ProvinciaAbm abm = new ProvinciaAbm();
		   
	
		     //Intentar Agregar provincia repetida
			 try {
		            abm.agregar("Buenos Aires");
		            System.out.println("Provincia agregada con éxito.");
		        } catch (IllegalArgumentException e) {
		            System.err.println("No se pudo agregar la provincia: " + e.getMessage());
		        }
			 try {
		            abm.agregar("La pampa");
		            System.out.println("Provincia agregada con éxito.");
		        } catch (IllegalArgumentException e) {
		            System.err.println("No se pudo agregar la provincia: " + e.getMessage());
		        }
			 try {
		            abm.agregar("Santa fe");
		            System.out.println("Provincia agregada con éxito.");
		        } catch (IllegalArgumentException e) {
		            System.err.println("No se pudo agregar la provincia: " + e.getMessage());
		        }
			 
			 //Usamos un for para traer todas las provincias por consola
			 for(Provincia c: abm.traer()) System.out.println(c);
			
			  Provincia provinciaModificar = abm.traerXnombre("Buenos aires");
				System.out.printf("Provincia a Modificar: %s\n\n", provinciaModificar);

				// modificar por set los atributos
			  provinciaModificar.setNombre("Rio Negro");
				
				// update del objeto
				abm.modificar(provinciaModificar);
				
				
			
				System.out.printf("Provincia Modificada: %s\n", provinciaModificar);
				
				
				System.out.printf("Eliminamos provincia de  la pampa\n");
				abm.eliminar(abm.traerXnombre("la pampa"));
				 //Mostramos la lista con la provincia eliminada
				System.out.printf("Mostramos la lista \n");
				 for(Provincia c: abm.traer()) System.out.println(c);
			 
			
		    }
			
	 }
	 
	 

