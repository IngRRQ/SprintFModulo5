package usuarioDAO;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;                                        
import java.util.List;
import modelos.Usuario;
import conexion.*;

public class UsuarioDAO implements IUsuarioDAO {

	private Connection conn = null;

	@Override
    public void agregarUsuario(Usuario usuario) {
		
    	 Statement stm = null;
    	 
    	 int rs = 0;
    	 
    	 String nombre= usuario.getNombre();
    	 String rut= usuario.getRut();
    	 String tipo= usuario.getTipo();

    	String sql = "INSERT INTO usuario (nombre, rut, tipo) VALUES ('"+nombre+"', '"+rut+"', '"+tipo+"')";
    	 
    	 try {
 			conn = ConexionDB.getConn();
 			System.out.println("desde DAO: " + conn);

 			stm = conn.createStatement();
 			rs = stm.executeUpdate(sql);
 			System.out.println(rs+" columnas afectadas");
 		
 			stm.close();

 		} catch (SQLException e) {
 			e.printStackTrace();
 		}

    }

	@Override
	public void actualizarUsuario(Usuario Usuario) {
// TODO Auto-generated method stub

	}

	@Override
	public void eliminarUsuario(int idU) {
		// TODO Auto-generated method stub

	}

	public List<Usuario> obtenerTodosLosUsuarios() {

		Statement stm = null;
		ResultSet rs = null;

		String sql = "select id_U, nombre, rut, tipo from Usuario;";

		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			conn = ConexionDB.getConn();
			System.out.println("desde DAO: " + conn);

			stm = conn.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				usuarios
						.add(new Usuario(rs.getInt("id_U"), rs.getString("nombre"), rs.getString("rut"), rs.getString("tipo")));

			}
			rs.close();
			stm.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarios;
	}

	@Override
	public Usuario obtenerUsuarioPorRut(String rut) {
		Statement stm = null;
		ResultSet rs = null;

		String sql = "select id_U, nombre, rut, tipo from Usuario where rut = '"+rut+"';";
		
		Usuario usuario =new Usuario();
		
		try {
			conn = ConexionDB.getConn();
			System.out.println("desde DAO: " + conn);

			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
	

			while (rs.next()) {
				usuario = new Usuario(rs.getInt("id_U"), rs.getString("nombre"), rs.getString("rut"), rs.getString("tipo"));

			}
			
			rs.close();
			stm.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}

}