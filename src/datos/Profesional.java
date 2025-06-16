package datos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.Hibernate;

public class Profesional extends Persona {
  
	private Integer matricula;
	private Especialidad especialidad;
	private Set<Disponibilidad> disponibilidades;
	private Set<Servicio> servicios;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lugar_id")
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
		Hibernate.initialize(lugar.getDireccion().getCalle());
		return super.toString()+"PROFESIONAL  matricula=" + matricula + ", especialidad=" +  ", lugar=" + lugar.getDireccion().getCalle() + "]";
	}


	
	

}