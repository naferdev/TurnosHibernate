package datos;

import java.time.LocalDate;

public abstract class Persona {
	protected int idPersona;
	protected String apellido;
	protected String nombre;
	protected int dni;
	protected Contacto contacto;
	
	public Persona() {}

	public Persona(String apellido, String nombre, int dni, Contacto contacto) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.contacto = contacto;
	}

	

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	@Override
	public String toString() {
		return "Persona [apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni + ", contacto=" + contacto + "]";
	}
	
	
}
