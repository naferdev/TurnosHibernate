package datos;
public class Direccion {
    private Long id;
    private Integer altura;
    private String calle;
    private Localidad localidad;
    private Provincia provincia;
    
    
    public Direccion() {
    }
    
    
	public Direccion(Long id, Integer altura, String calle, Localidad localidad, Provincia provincia) {
		super();
		this.id = id;
		this.altura = altura;
		this.calle = calle;
		this.localidad = localidad;
		this.provincia = provincia;
	}

	  // Getters y Setters

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getAltura() {
		return altura;
	}


	public void setAltura(Integer altura) {
		this.altura = altura;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public Localidad getLocalidad() {
		return localidad;
	}


	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}


	public Provincia getProvincia() {
		return provincia;
	}


	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}


	@Override
	public String toString() {
		
		return "Direccion [id=" + id + ", altura=" + altura + ", calle=" + calle + "]";
	}

 
	
    
    
}





