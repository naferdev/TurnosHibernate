package datos;

import java.time.LocalDate;

public abstract class Persona {
    private Long id;
    private String tipoPersona;
    private int dni;
    private String nombre;
    private Contacto contacto;
  
 

	public Persona() {
    }
    
	public Persona(Long id, String tipoPersona, int dni, String nombre, Contacto contacto) {
		super();
		this.id = id;
		this.tipoPersona = tipoPersona;
		this.dni = dni;
		this.nombre = nombre;
		this.contacto=contacto;
		
	}

	

    // Getters y Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	   
    public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto coctacto) {
		this.contacto = coctacto;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", tipoPersona=" + tipoPersona + ", dni=" + dni + ", nombre=" + nombre + "]";
	}

	

}