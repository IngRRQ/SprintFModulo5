package dao;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.Usuario;
import conexion.ConexionDB;

/**
 * Implementación de la interfaz IUsuarioDAO para manejar operaciones CRUD sobre la entidad Usuario en la base de datos.
 * Proporciona métodos para agregar, eliminar y recuperar usuarios.
 */
public class UsuarioDAO implements IUsuarioDAO {

    private Connection conn = null;

    /**
     * Agrega un nuevo usuario a la base de datos.
     * 
     * @param usuario El objeto Usuario que contiene la información a insertar.
     */
    @Override
    public void agregarUsuario(Usuario usuario) {
        Statement stm = null;
        int rs = 0;

        String nombre = usuario.getNombre();
        String rut = usuario.getRut();
        String tipo = usuario.getTipo();

        String sql = "INSERT INTO usuario (nombre, rut, tipo) VALUES ('" + nombre + "', '" + rut + "', '" + tipo + "')";

        try {
            conn = ConexionDB.getConn();
            System.out.println("desde DAO: " + conn);

            stm = conn.createStatement();
            rs = stm.executeUpdate(sql);
            System.out.println(rs + " columnas afectadas");

            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza la información de un usuario en la base de datos.
     * 
     * @param usuario El objeto Usuario que contiene la información actualizada.
     */
    @Override
    public void actualizarUsuario(Usuario usuario) {
        // TODO: Implementar el método para actualizar la información de un usuario.
    }

    /**
     * Elimina un usuario de la base de datos basado en su ID.
     * 
     * @param idU El ID del usuario que se eliminará.
     */
    @Override
    public void eliminarUsuario(int idU) {
        // TODO: Implementar el método para eliminar un usuario basado en su ID.
    }

    /**
     * Recupera todos los usuarios de la base de datos.
     * 
     * @return Una lista de objetos Usuario que representan a todos los usuarios registrados.
     */
    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT id_U, nombre, rut, tipo FROM Usuario;";

        List<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            conn = ConexionDB.getConn();
            System.out.println("desde DAO: " + conn);

            stm = conn.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                usuarios.add(new Usuario(rs.getInt("id_U"), rs.getString("nombre"), rs.getString("rut"), rs.getString("tipo")));
            }
            rs.close();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    /**
     * Recupera un usuario específico basado en su RUT.
     * 
     * @param rut El RUT del usuario a recuperar.
     * @return El objeto Usuario que corresponde al RUT proporcionado.
     */
    @Override
    public Usuario obtenerUsuarioPorRut(String rut) {
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT id_U, nombre, rut, tipo FROM Usuario WHERE rut = '" + rut + "';";
        
        Usuario usuario = new Usuario();

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
