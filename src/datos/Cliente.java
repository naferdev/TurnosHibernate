package datos;

public class Cliente extends Persona {
	private int nroCliente;

	public Cliente() {}
	
	public Cliente(int nroCliente) {
		super();
		this.nroCliente = nroCliente;
	}

	public int getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(int nroCliente) {
		this.nroCliente = nroCliente;
	}

	@Override
	public String toString() {
		return "Cliente [nroCliente=" + nroCliente + ", apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni
				+ ", contacto=" + contacto + "]";
	}


	
	
	
}





