package test;

import negocio.ProvinciaAbm;

public class TestProvincia {
	
	 public static void main(String[] args) {
		     ProvinciaAbm abm = new ProvinciaAbm();
		     System.out.println(abm.traer(1).toString());
			
			 try {
		            abm.agregar("la paMpa");
		            System.out.println("Provincia agregada con éxito.");
		        } catch (IllegalArgumentException e) {
		            System.err.println("No se pudo agregar la provincia: " + e.getMessage());
		        }
		    }
			
	 }
	 
	 

