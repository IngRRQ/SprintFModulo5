package dao;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.Cliente;
import conexion.ConexionDB;

/**
 * Implementación de la interfaz IClienteDAO para manejar operaciones relacionadas con la entidad Cliente en la base de datos.
 * Esta clase proporciona métodos para agregar, actualizar, eliminar y obtener clientes.
 * 
 * @see IClienteDAO
 */
public class ClienteDAO implements IClienteDAO {

    private Connection conn = null;

    /**
     * Agrega un nuevo cliente a la base de datos.
     * 
     * @param cliente El objeto Cliente que se va a agregar.
     */
    @Override
    public void agregarCliente(Cliente cliente) {
        Statement stm = null;
        int rs = 0;

        String telefono = cliente.getTelefono();
        String comuna = cliente.getComuna();
        int id_U = cliente.getId();

        String sql = "INSERT INTO cliente (telefono, comuna, id_U) VALUES ('" + telefono + "', '" + comuna + "', " + id_U + ")";

        try {
            conn = ConexionDB.getConn();
            stm = conn.createStatement();
            rs = stm.executeUpdate(sql);
            System.out.println(rs + " columnas afectadas");
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Actualiza los datos de un cliente en la base de datos.
     * 
     * @param cliente El objeto Cliente con los datos actualizados.
     */
    @Override
    public void actualizarCliente(Cliente cliente) {
        Statement stm = null;
        int rs = 0;

        String nombre = cliente.getNombre();
        String rut = cliente.getRut();
        String telefono = cliente.getTelefono();
        String comuna = cliente.getComuna();
        int id_CL = cliente.getIdCL();
        int id_U = cliente.getId();

        String sql1 = "UPDATE cliente SET telefono = '" + telefono + "', comuna = '" + comuna + "' WHERE id_CL = " + id_CL + ";";
        String sql2 = "UPDATE usuario SET nombre = '" + nombre + "', rut = '" + rut + "' WHERE id_U = " + id_U + ";";

        try {
            conn = ConexionDB.getConn();
            stm = conn.createStatement();
            rs = stm.executeUpdate(sql1);
            System.out.println(rs + " columnas afectadas");
            rs = stm.executeUpdate(sql2);
            System.out.println(rs + " columnas afectadas");
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un cliente de la base de datos basándose en el ID del usuario asociado.
     * 
     * @param idU El ID del usuario asociado al cliente que se va a eliminar.
     */
    @Override
    public void eliminarCliente(int idU) {
        Statement stm = null;
        int rs = 0;

        String sql = "DELETE FROM usuario WHERE id_U = " + idU + ";";

        try {
            conn = ConexionDB.getConn();
            stm = conn.createStatement();
            rs = stm.executeUpdate(sql);
            System.out.println(rs + " columnas afectadas");
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene todos los clientes de la base de datos.
     * 
     * @return Una lista de objetos Cliente que representan todos los clientes en la base de datos.
     */
    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT u.id_U, u.nombre, u.rut, u.tipo, c.id_CL, c.telefono, c.comuna FROM Cliente c INNER JOIN usuario u ON c.id_U = u.id_U;";

        List<Cliente> clientes = new ArrayList<>();

        try {
            conn = ConexionDB.getConn();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                clientes.add(new Cliente(rs.getInt("id_U"), rs.getString("nombre"), rs.getString("rut"),
                        rs.getString("tipo"), rs.getInt("id_CL"), rs.getString("telefono"), rs.getString("comuna")));
            }
            rs.close();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    /**
     * Obtiene un cliente de la base de datos basándose en el ID del cliente.
     * 
     * @param idCL El ID del cliente a obtener.
     * @return Un objeto Cliente con los datos del cliente correspondiente al ID proporcionado.
     */
    @Override
    public Cliente obtenerClientePorId(int idCL) {
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT u.id_U, u.nombre, u.rut, u.tipo, c.id_CL, c.telefono, c.comuna FROM Cliente c INNER JOIN Usuario u ON u.id_U = c.id_U WHERE id_CL = '" + idCL + "';";

        Cliente cliente = new Cliente();

        try {
            conn = ConexionDB.getConn();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                cliente = new Cliente(rs.getInt("id_U"), rs.getString("nombre"), rs.getString("rut"),
                        rs.getString("tipo"), rs.getInt("id_CL"), rs.getString("telefono"), rs.getString("comuna"));
            }

            rs.close();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }
}
