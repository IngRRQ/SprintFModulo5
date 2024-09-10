package dao;

import java.util.List;
import modelos.Profesional;

/**
 * Interfaz para manejar operaciones relacionadas con la entidad Profesional en la base de datos.
 * Esta interfaz define los métodos necesarios para realizar operaciones CRUD (crear, leer, actualizar y eliminar)
 * sobre los registros de profesionales.
 */
public interface IProfesionalDAO {

    void agregarProfesional(Profesional profesional);
    void actualizarProfesional(Profesional profesional);
    void eliminarProfesional(int idPF);
    Profesional obtenerProfesionalPorId(int idPF);
    List<Profesional> obtenerTodosLosProfesionales();
}
