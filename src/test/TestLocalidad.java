package test;


import datos.Localidad;
import datos.Provincia;
import negocio.LocalidadAbm;
import negocio.ProvinciaAbm;

public class TestLocalidad {
	
	 public static void main(String[] args) {
		 
		     LocalidadAbm localidadabm = new LocalidadAbm();
		     
		     //System.out.println(localidadabm.traer(1).toString());
			
			 try {
				   localidadabm.agregar("Burzaco",1);
		            System.out.println("Localidad agregada con éxito.");
		        } catch (IllegalArgumentException e) {
		            System.err.println("No se pudo agregar la Localidad: " + e.getMessage());
		        }
			 
			 
			 
			 System.out.println(localidadabm.traerLocalidadyProvincia(2383));
			 //Usamos un for para traer todas las Localidad por consola
			 for(Localidad c: localidadabm.traer()) System.out.println(c);
			
			 
			 
			 
		    }
			
	 }
	 
	 

