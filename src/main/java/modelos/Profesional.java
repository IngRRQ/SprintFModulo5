package modelos;

/**
 * Representa a un profesional, extendiendo de la clase Usuario. 
 * Incluye información específica como título y fecha de ingreso.
 */
public class Profesional extends Usuario {

	private int idPF;
    private String titulo;
    private String fechaIngreso;

    public Profesional() {
        super();
    }

    public Profesional(int idU, String nombre, String rut, String tipo, int idPF, String titulo, String fechaIngreso) {
        super(idU, nombre, rut, tipo);
        this.idPF = idPF;
        this.titulo = titulo;
        this.fechaIngreso = fechaIngreso;
    }

    public int getIdPF() {
		return idPF;
	}

	public void setIdPF(int idPF) {
		this.idPF = idPF;
	}

	public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    // Método toString
    @Override
    public String toString() {
        return " Profesional [Titulo=" + titulo + ", Fecha de Ingreso=" + fechaIngreso + "]";
    }
}
