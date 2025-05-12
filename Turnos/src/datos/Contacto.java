package datos;

public class Contacto {
	private int idContacto;
	private String email;
	private int movil;
	private String calle;
	private String numero;
	private String localidad;
	
	public Contacto() {}
	


	public Contacto(String email, int movil, String calle, String numero, String localidad) {
		super();
		this.email = email;
		this.movil = movil;
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
	}

	public int getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMovil() {
		return movil;
	}

	public void setMovil(int movil) {
		this.movil = movil;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	@Override
	public String toString() {
		return "Contacto [email=" + email + ", movil=" + movil + ", calle=" + calle + ", numero=" + numero
				+ ", localidad=" + localidad + "]";
	}
	
	
}
