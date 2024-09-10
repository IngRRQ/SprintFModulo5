package dao;

import java.util.List;
import modelos.Usuario;

/**
 * Interfaz para manejar operaciones relacionadas con la entidad Usuario en la base de datos.
 * Esta interfaz define los métodos necesarios para realizar operaciones CRUD (crear, leer, actualizar y eliminar)
 * sobre los registros de usuarios.
 */
public interface IUsuarioDAO {

    void agregarUsuario(Usuario usuario);
    void actualizarUsuario(Usuario usuario);
    void eliminarUsuario(int idU);
    Usuario obtenerUsuarioPorRut(String rut);
    List<Usuario> obtenerTodosLosUsuarios();
}
