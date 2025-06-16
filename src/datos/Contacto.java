package datos;

public class Contacto {
    private Long id;
    private String email;
    private Integer movil;
    private Integer telefono;
    private Direccion direccion;
    private Persona persona;
    
    public Contacto() {
    }
	public Contacto(Long id, String email, Integer movil, Integer telefono, Direccion direccion,Persona persona) {
		super();
		this.id = id;
		this.email = email;
		this.movil = movil;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	

    // Getters y Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getMovil() {
		return movil;
	}
	public void setMovil(Integer movil) {
		this.movil = movil;
	}
	public Integer getTelefono() {
		return telefono;
	}
	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public Persona getPersona() { return persona; }
    public void setPersona(Persona persona) { this.persona = persona; }
    
	
	@Override
	public String toString() {
		return "Contacto [id=" + id + ", email=" + email + ", movil=" + movil + ", telefono=" + telefono
				+ ", direccion=" +  (direccion != null ? direccion.getCalle() : "null") +  (direccion != null ? direccion.getAltura() : "null");
	}

	
}