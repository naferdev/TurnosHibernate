package test;



import datos.Provincia;
import negocio.LocalidadAbm;
import negocio.ProvinciaAbm;

public class TestProvincia {
	
	 public static void main(String[] args) {
		     ProvinciaAbm abm = new ProvinciaAbm();
		   
		     //Traer por id
		     System.out.println(abm.traer(1).toString());
			 Provincia modificar=abm.traer(1);
			 
		     //Intentar Agregar provincia repetida
			 try {
		            abm.agregar("la paMpa");
		            System.out.println("Provincia agregada con éxito.");
		        } catch (IllegalArgumentException e) {
		            System.err.println("No se pudo agregar la provincia: " + e.getMessage());
		        }
			 
			 //Usamos un for para traer todas las provincias por consola
			 for(Provincia c: abm.traer()) System.out.println(c);
			
			
				System.out.printf("Provincia a Modificar: %s\n\n", modificar);

				// modificar por set los atributos
				modificar.setNombre("Rio Negro");
				
				// update del objeto
				abm.modificar(modificar);
				
				Provincia provinciaMod = abm.traer(1);
				//
				System.out.printf("Provincia Modificada: %s\n", provinciaMod);
				
				//eliminar objeto
				abm.eliminar(abm.traer(26));
				 //Mostramos la lista con la provincia eliminada
				 for(Provincia c: abm.traer()) System.out.println(c);
			 
			 
		    }
			
	 }
	 
	 

