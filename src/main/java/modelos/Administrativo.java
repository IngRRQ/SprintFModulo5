package modelos;

/**
 * Representa a un Administrativo, que es una extensión de Usuario con información adicional 
 * relacionada con su área de trabajo y experiencia previa.
 */
public class Administrativo extends Usuario {

    private int idAD;
    private String area;
    private String experienciaPrevia;

    public Administrativo() {
        super();
    }

    public Administrativo(int idU, String nombre, String rut, String tipo, int idAD, String area, String experienciaPrevia) {
        super(idU, nombre, rut, tipo);
        this.idAD = idAD;
        this.area = area;
        this.experienciaPrevia = experienciaPrevia;
    }

    public String getArea() {
        return area;
    }

    public int getIdAD() {
        return idAD;
    }

    public void setIdAD(int idAD) {
        this.idAD = idAD;
    }

    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setExperienciaPrevia(String experienciaPrevia) {
        this.experienciaPrevia = experienciaPrevia;
    }

    @Override
    public String toString() {
        return "Administrativo [Area=" + area + ", ExperienciaPrevia=" + experienciaPrevia + "]";
    }
}
