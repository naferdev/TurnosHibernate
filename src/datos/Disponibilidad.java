package datos;

import java.util.Date;

public class Disponibilidad {
    private Long id;
    private Long duracion;
    private java.util.Date inicio;
    private Boolean ocupado;
    private Persona profesional;
   
    public Disponibilidad() {}
    
	public Disponibilidad(Long id, Long duracion, Date inicio, Boolean ocupado, Persona profesional) {
		super();
		this.id = id;
		this.duracion = duracion;
		this.inicio = inicio;
		this.ocupado = ocupado;
		this.profesional = profesional;
	}


    // Getters y Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDuracion() {
		return duracion;
	}

	public void setDuracion(Long duracion) {
		this.duracion = duracion;
	}

	public java.util.Date getInicio() {
		return inicio;
	}

	public void setInicio(java.util.Date inicio) {
		this.inicio = inicio;
	}

	public Boolean getOcupado() {
		return ocupado;
	}

	public void setOcupado(Boolean ocupado) {
		this.ocupado = ocupado;
	}

	public Persona getProfesional() {
		return profesional;
	}

	public void setProfesional(Persona profesional) {
		this.profesional = profesional;
	}

	@Override
	public String toString() {
		
		return "Disponibilidad [id=" + id + ", duracion=" + duracion + ", inicio=" + inicio + ", ocupado=" + ocupado
				+ ", profesional=" + profesional + "]";
	}
	
	
    
    
}