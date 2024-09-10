package Interfaces;

import java.util.List;
import modelos.Capacitacion;

public interface ICapacitacion {

    List<Capacitacion> obtenerCapacitaciones();

    void registrarCapacitacion(Capacitacion capacitacion);
}
