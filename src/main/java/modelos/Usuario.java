package modelos;

/**
 * Representa un usuario genérico en el sistema, con atributos básicos como id, nombre, rut y tipo.
 */
public class Usuario {
	
	private int idU;
    private String nombre;
    private String rut;
    private String tipo;

    public Usuario() {
        super();
    }

    public Usuario(int idU, String nombre, String rut, String tipo) {
        super();
        this.idU = idU;
        this.nombre = nombre;
        this.rut = rut;
        this.tipo = tipo;
    }
    
    public int getId() {
		return idU;
	}

	public void setId(int idU) {
		this.idU = idU;
	}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
    
    public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	// Método toString
	public String toString() {
		return "Usuario [idU=" + idU + ", nombre=" + nombre + ", rut=" + rut + ", tipo=" + tipo + "]";
	}
}