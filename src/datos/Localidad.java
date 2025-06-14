package datos;
public class Localidad {
    private Long id;
    private String nombre;
    private Provincia provincia;
    
  
    
    
    public Localidad() {}
    
	public Localidad(Long id, String nombre, Provincia provincia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.provincia = provincia;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
/*
	@Override
	public String toString() {
		return "Localidad [id=" + id + ", nombre=" + nombre + "]";
	}
	*/
	public String toString() {
	return "Localidad{id=" + id + ", nombre='" + nombre + '\'' +
	           ", provincia=" + (provincia != null ? provincia.getNombre() : "null") + '}';
	}

  
    
}
	
	
	






