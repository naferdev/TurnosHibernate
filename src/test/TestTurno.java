package test;

import datos.Disponibilidad;
import datos.Lugar;
import datos.Persona;
import datos.Servicio;
import negocio.DisponibilidadAbm;
import negocio.LugarAbm;
import negocio.PersonaAbm;
import negocio.ServicioAbm;
import negocio.TurnoABM;

public class TestTurno {
	public static void main(String[] args) {
		PersonaAbm personaAbm = new PersonaAbm();
		DisponibilidadAbm disponibilidadAbm = new DisponibilidadAbm();
		ServicioAbm servicioAbm = new ServicioAbm();
		LugarAbm lugarAbm = new LugarAbm();
		TurnoABM turnoAbm = new TurnoABM();
		
		//DATOS PRECARGADOS POR BASE
		Persona cliente = personaAbm.traer(1000);
		Persona profesional = personaAbm.traer(1001);
		Disponibilidad disponibilidad = disponibilidadAbm.traer(2);
		Servicio servicio = servicioAbm.traer(1001);
		Lugar lugar = lugarAbm.traer(1);
		
		//turnoAbm.Agregar(cliente.getId(), profesional.getId(), disponibilidad.getId(), servicio.getId(), lugar.getId());
		
		System.out.println(turnoAbm.traerTurnoCompleto(33));
	}
}
