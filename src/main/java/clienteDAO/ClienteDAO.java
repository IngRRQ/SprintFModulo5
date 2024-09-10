package clienteDAO;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.Cliente;
import conexion.*;

public class ClienteDAO implements IClienteDAO {

	private Connection conn = null;

	@Override
	public void agregarCliente(Cliente cliente) {

		Statement stm = null;

		int rs = 0;

		String telefono = cliente.getTelefono();
		String comuna = cliente.getComuna();
		int id_U = cliente.getId();

		String sql = "INSERT INTO cliente (telefono, comuna, id_U) VALUES ('" + telefono + "', '" + comuna + "'," + id_U
				+ ")";

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
			System.out.println("desde DAO: " + conn);

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

	@Override
	public void eliminarCliente(int idU) {
		Statement stm = null;
		int rs = 0;

		String sql = "DELETE FROM usuario WHERE id_U =" + idU + ";";

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

	public List<Cliente> obtenerTodosLosClientes() {

		Statement stm = null;
		ResultSet rs = null;

		String sql = "select u.id_U, u.nombre, u.rut, u.tipo, c.id_CL, c.telefono, c.comuna from Cliente c inner join usuario u on c.id_U = u.id_U;";

		List<Cliente> cliente = new ArrayList<Cliente>();

		try {
			conn = ConexionDB.getConn();
			System.out.println("desde DAO: " + conn);

			stm = conn.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				cliente.add(new Cliente(rs.getInt("id_U"), rs.getString("nombre"), rs.getString("rut"),
						rs.getString("tipo"), rs.getInt("id_CL"), rs.getString("telefono"), rs.getString("comuna")));

			}
			rs.close();
			stm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cliente;
	}

	@Override
	public Cliente obtenerClientePorId(int idCL) {
		Statement stm = null;
		ResultSet rs = null;
		String sql = "select u.id_U, u.nombre, u.rut, u.tipo, c.id_CL, c.telefono, c.comuna from Cliente c inner join Usuario u on u.id_U = c.id_U where id_CL = '" + idCL + "';";

		Cliente cliente = new Cliente();

		try {
			conn = ConexionDB.getConn();
			System.out.println("desde DAO: " + conn);

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
