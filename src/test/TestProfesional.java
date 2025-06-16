package test;

import datos.Persona;
import negocio.PersonaAbm;

public class TestProfesional {
    public static void main(String[] args) {
        //Traer datos de un profesional
    	int profesionalId = 1;
    	PersonaAbm personaABM = new PersonaAbm();
    	Persona persona = personaABM.traer(profesionalId);
    	System.out.println("+ traer("+profesionalId+")");
    	System.out.println(persona.toString());
    }
}
