package modelos;

/**
 * Representa una sesión de capacitación, con detalles sobre el día, hora, lugar,
 * duración y cantidad de asistentes.
 */
public class Capacitacion {

    private int identificador;
    private String dia;
    private String hora;
    private String lugar;
    private String duracion;
    private int cantidadAsistentes;

    public Capacitacion() {
    }

    public Capacitacion(int identificador, String dia, String hora, String lugar, String duracion,
           int cantidadAsistentes) {
        this.identificador = identificador;  
        this.dia = dia;						
        this.hora = hora;					
        this.lugar = lugar;					
        this.duracion = duracion;			
        this.cantidadAsistentes = cantidadAsistentes; 
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    public void setCantidadAsistentes(int cantidadAsistentes) {
        this.cantidadAsistentes = cantidadAsistentes;
    }

    @Override
    public String toString() {
        return "Capacitacion [identificador=" + identificador + ", Dia=" + dia + ", Hora="
                + hora + ", Lugar=" + lugar + ", Duracion=" + duracion + ", Cantidad de Asistentes=" + cantidadAsistentes + "]";
    }
}
