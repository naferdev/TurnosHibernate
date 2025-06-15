package test;


import java.sql.Time;

import datos.Direccion;
import datos.Localidad;
import datos.Lugar;
import datos.Provincia;
import negocio.LocalidadAbm;
import negocio.LugarAbm;
import negocio.ProvinciaAbm;
import negocio.DireccionAbm;

public class TestLugar {
	
	 public static void main(String[] args) {
		 	
		     DireccionAbm direccionabm = new DireccionAbm();
		     LugarAbm lugarabm = new LugarAbm();
		     //System.out.println(localidadabm.traer(1).toString());
		     // Horarios de ejemplo
		        Time horarioApertura = Time.valueOf("08:00:00");
		        Time horarioCierre = Time.valueOf("18:00:00");
		        Time horarioCierreModificar = Time.valueOf("20:00:00");
		  
			 try {
				 lugarabm.agregar(horarioApertura,horarioCierre, 9);
		
		            System.out.println("Lugar agregada con éxito.");
		        } catch (IllegalArgumentException e) {
		            System.err.println("No se pudo agregar El lugar: " + e.getMessage());
		
			 
			 	
			System.out.println(lugarabm.traerLugarYdireccion(9));
			 //Usamos un for para traer todas las Localidad por consola
			 for(Lugar c: lugarabm.traer()) System.out.println(c);
			
	        Lugar lugarModificar = lugarabm.traerLugarYdireccion(9);
			
			
			 System.out.printf("Direccion a Modificar: %s\n\n", lugarModificar);

				// modificar por set los atributos
			 lugarModificar.setHorarioCierre(horarioCierreModificar);
			
			
				
			 // update del objeto
			 lugarabm.modificar(lugarModificar);
			
			
			
			 System.out.printf("Localidad Modificada: %s\n\n", lugarabm.traerLugarYdireccion(9));
			
			
			 System.out.printf("Localidad a Eliminar: %s\n\n",lugarabm.traerLugarYdireccion(13));
			 Lugar lugarEliminar = lugarabm.traerLugarYdireccion(13);
			 lugarabm.eliminar(lugarEliminar);
			
			 //Usamos un for para traer todas las Localidad por consola
			 for(Lugar c: lugarabm.traer()) System.out.println(c);
			 
		    }
			
	 }}
	 
	 

