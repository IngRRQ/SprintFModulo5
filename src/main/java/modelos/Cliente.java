package modelos;

/**
 * Representa un cliente, que extiende de la clase Usuario. 
 * Incluye detalles específicos como teléfono y comuna.
 */
public class Cliente extends Usuario {

	private int idCL;
	private String telefono;
    private String comuna;

    public Cliente() {
        super();
    }

    public Cliente(int idU, String nombre, String rut, String tipo,  int idCL, String telefono, String comuna) {
        super(idU, nombre, rut, tipo);
        this.idCL = idCL;
        this.telefono = telefono;
        this.comuna = comuna;
    }

	public int getIdCL() {
		return idCL;
	}

	public void setIdCL(int idCL) {
		this.idCL = idCL;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	@Override
	public String toString() {
		return "Cliente [telefono=" + telefono + ", comuna=" + comuna + "]";
	}
}
