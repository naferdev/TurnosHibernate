package datos;

import java.sql.Time;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Lugar {
    private Long id;
    private java.sql.Time horarioApertura;
    private java.sql.Time horarioCierre;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "direccion_id")
    private Direccion direccion;
    
    
    private Set<Servicio> servicios;

    public Lugar() {
    }
    
	public Lugar(Long id, Time horarioApertura, Time horarioCierre, Direccion direccion) {
		super();
		this.id = id;
		this.horarioApertura = horarioApertura;
		this.horarioCierre = horarioCierre;
		this.direccion = direccion;
	}
	 // Getters y Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public java.sql.Time getHorarioApertura() {
		return horarioApertura;
	}

	public void setHorarioApertura(java.sql.Time horarioApertura) {
		this.horarioApertura = horarioApertura;
	}

	public java.sql.Time getHorarioCierre() {
		return horarioCierre;
	}

	public void setHorarioCierre(java.sql.Time horarioCierre) {
		this.horarioCierre = horarioCierre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Lugar [id=" + id + ", horarioApertura=" + horarioApertura + ", horarioCierre=" + horarioCierre + "]";
	}
	
	
	public Set<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(Set<Servicio> servicios) {
        this.servicios = servicios;
    }
    
   
}
