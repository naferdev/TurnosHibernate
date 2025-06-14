package datos;
public class Provincia {

    private long id;
    private String nombre;

    // Constructor vacío (requerido por Hibernate)
    public Provincia() {
    }

    // Constructor con parámetros (opcional)
    public Provincia(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // toString (opcional pero útil para depuración)
    @Override
    public String toString() {
        return "Provincia{" +  "id=" + id + ", nombre='" + nombre + '\'' + '}';
    }
}
	
	
	






