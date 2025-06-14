package datos;

import java.util.Set;

public class Servicio {
	private Long id;
    private String descripcion;
    private String nombre;
    private Double precio;

    private Set<Lugar> lugares;
    private Set<Persona> profesionales;

    
    public Servicio() {
    	
    }
    // Getters y Setters

    public Servicio(Long id, String descripcion, String nombre, Double precio, Set<Lugar> lugares,
			Set<Persona> profesionales) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.precio = precio;
		this.lugares = lugares;
		this.profesionales = profesionales;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Set<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(Set<Lugar> lugares) {
        this.lugares = lugares;
    }

    public Set<Persona> getProfesionales() {
        return profesionales;
    }

    public void setProfesionales(Set<Persona> profesionales) {
        this.profesionales = profesionales;
    }

	@Override
	public String toString() {
		return "Servicio [id=" + id + ", descripcion=" + descripcion + ", nombre=" + nombre + ", precio=" + precio
				+ ", lugares=" + lugares + ", profesionales=" + profesionales + "]";
	}
    
    
}