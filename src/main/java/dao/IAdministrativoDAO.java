package dao;

import java.util.List;
import modelos.Administrativo;

/**
 * Interfaz para manejar operaciones relacionadas con la entidad Administrativo en la base de datos.
 * Esta interfaz define los métodos necesarios para realizar operaciones CRUD (crear, leer, actualizar y eliminar)
 * sobre los registros de administrativos.
 */
public interface IAdministrativoDAO {

    
    void agregarAdministrativo(Administrativo administrativo);
    void actualizarAdministrativo(Administrativo administrativo);
    void eliminarAdministrativo(int idAD);
    Administrativo obtenerAdministrativoPorId(int idAD);
    List<Administrativo> obtenerTodosLosAdministrativos();
}
