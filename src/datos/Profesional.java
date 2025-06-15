package datos;

import java.util.HashSet;
import java.util.Set;

public class Profesional extends Persona {
  
	private Integer matricula;
	private Especialidad especialidad;
	private Set<Disponibilidad> disponibilidades;
	private Set<Servicio> servicios;
	private Lugar lugar;
	
	
	public Profesional() {
    }


	public Profesional(Long id, String tipoPersona, int dni, String nombre, Contacto contacto, Integer matricula,
			Especialidad especialidad, Set<Disponibilidad> disponibilidades, Set<Servicio> servicios, Lugar lugar) {
		super(id, tipoPersona, dni, nombre, contacto);
		this.matricula = matricula;
		this.especialidad = especialidad;
		this.disponibilidades = disponibilidades;
		this.servicios = servicios;
		this.lugar = lugar;
	}





	public Integer getMatricula() {
		return matricula;
	}


	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}


	public Especialidad getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}


	public Set<Disponibilidad> getDisponibilidades() {
		return disponibilidades;
	}


	public void setDisponibilidades(Set<Disponibilidad> disponibilidades) {
		this.disponibilidades = disponibilidades;
	}


	public Set<Servicio> getServicios() {
		return servicios;
	}


	public void setServicios(Set<Servicio> servicios) {
		this.servicios = servicios;
	}


	public Lugar getLugar() {
		return lugar;
	}


	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}


	@Override
	public String toString() {
		
		return super.toString()+"PROFESIONAL  matricula=" + matricula + ", especialidad=" + especialidad + ", disponibilidades="
				+ disponibilidades + ", servicios=" + servicios + ", lugar=" + lugar + "]";
	}


	
	

}