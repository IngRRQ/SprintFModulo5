package dao;

import java.util.List;
import modelos.Capacitacion;

/**
 * Interfaz para manejar operaciones relacionadas con la entidad Capacitacion en la base de datos.
 * Esta interfaz define los métodos necesarios para realizar operaciones CRUD (crear, leer, actualizar y eliminar)
 * sobre los registros de capacitaciones.
 */
public interface ICapacitacionDAO {

    void agregarCapacitacion(Capacitacion capacitacion);
    void actualizarCapacitacion(Capacitacion capacitacion);
    void eliminarCapacitacion(int identificador);
    Capacitacion obtenerCapacitacionPorId(int id);
    List<Capacitacion> obtenerTodasLasCapacitaciones();
}
