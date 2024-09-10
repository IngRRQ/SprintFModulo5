package usuarioDAO;

import java.util.List;
import modelos.Usuario;

public interface IUsuarioDAO {

	
	void agregarUsuario(Usuario Usuario);
    void actualizarUsuario(Usuario Usuario);
    void eliminarUsuario(int idU);
    Usuario obtenerUsuarioPorRut(String rut);
	List<Usuario> obtenerTodosLosUsuarios();
}
