package datos;

import java.util.Set;

public class Cliente extends Persona {
	private String nroCliente;
	private Set<Turno> lstTurnos;
	
	public Cliente() {
    }


	public Cliente(Long id, String tipoPersona, int dni, String nombre, Contacto contacto, String nroCliente,
			Set<Turno> lstTurnos) {
		super(id, tipoPersona, dni, nombre, contacto);
		this.nroCliente = nroCliente;
		this.lstTurnos = lstTurnos;
	}


	public String getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(String nroCliente) {
		this.nroCliente = nroCliente;
	}

	public Set<Turno> getLstTurnos() {
		return lstTurnos;
	}

	public void setLstTurnos(Set<Turno> lstTurnos) {
		this.lstTurnos = lstTurnos;
	}

	@Override
	public String toString() {
		return "Cliente [nroCliente=" + nroCliente + ", lstTurnos=" + lstTurnos + "]";
	}

	
}