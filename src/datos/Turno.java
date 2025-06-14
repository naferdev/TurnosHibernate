package datos;
public class Turno {

    private Long id;

    private Persona cliente;       // Cliente que reserva el turno
    private Persona profesional;   // Profesional que atiende
    private Disponibilidad disponibilidad; // Horario reservado
    private Servicio servicio;     // Servicio que se presta
    private Lugar lugar;           // Lugar donde se realiza

    
    public Turno() {
    	
    }
    // Getters y Setters

    public Turno(Long id, Persona cliente, Persona profesional, Disponibilidad disponibilidad, Servicio servicio,
			Lugar lugar) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.profesional = profesional;
		this.disponibilidad = disponibilidad;
		this.servicio = servicio;
		this.lugar = lugar;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public Persona getProfesional() {
        return profesional;
    }

    public void setProfesional(Persona profesional) {
        this.profesional = profesional;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

	@Override
	public String toString() {
		return "Turno [id=" + id + ", cliente=" + cliente + ", profesional=" + profesional + ", disponibilidad="
				+ disponibilidad + ", servicio=" + servicio + ", lugar=" + lugar + "]";
	}
    
    
}
	






