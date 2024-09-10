package profesionalDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionDB;
import modelos.Profesional;

public class ProfesionalDAO implements IProfesionalDAO{



	private Connection conn = null;

	@Override
    public void agregarProfesional(Profesional profesional) {
		
    	 Statement stm = null;
    	 
    	 int rs = 0;
    	 
    	 String titulo= profesional.getTitulo();
    	 String fechaIngreso= profesional.getFechaIngreso();
    	 int id_U = profesional.getId();
   

    	String sql = "INSERT INTO profesional (titulo, fecha_ingreso, id_U) VALUES ('"+titulo+"', '"+fechaIngreso+"', "+id_U+")";
    	 
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
	public void actualizarProfesional(Profesional profesional) {
		Statement stm = null;
   	 int rs = 0;
   	 
   	 String nombre = profesional.getNombre();
   	 String rut = profesional.getRut();
   	 String titulo= profesional.getTitulo();
   	 String fechaIngreso= profesional.getFechaIngreso();
   	 int id_PF = profesional.getIdPF();
   	 int id_U = profesional.getId();	    	 

   	String sql1 = "UPDATE profesional SET titulo = '" + titulo + "', fecha_ingreso = '" + fechaIngreso + "' WHERE id_PF = " + id_PF + ";";
	String sql2 = "UPDATE usuario SET nombre = '" + nombre + "', rut = '" + rut + "' WHERE id_U = " + id_U + ";";
   	 
   	 try {
			conn = ConexionDB.getConn();
			System.out.println("desde DAO: " + conn);

			stm = conn.createStatement();
			rs = stm.executeUpdate(sql1);
			System.out.println(rs+" columnas afectadas");
			rs = stm.executeUpdate(sql2);
			System.out.println(rs+" columnas afectadas");
		
			stm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void eliminarProfesional(int idU) {
		Statement stm = null;
    	int rs = 0;
    	
    	String sql = "DELETE FROM usuario WHERE id_U =" + idU+";";
    	
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

	public List<Profesional> obtenerTodosLosProfesionales() {

		Statement stm = null;
		ResultSet rs = null;

		String sql = "select u.id_U, u.nombre, u.rut, u.tipo, p.id_PF, p.titulo, p.fecha_ingreso from Profesional p inner join usuario u on p.id_U = u.id_U;";

		List<Profesional> profesional = new ArrayList<Profesional>();

		try {
			conn = ConexionDB.getConn();
			System.out.println("desde DAO: " + conn);

			stm = conn.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				profesional
				.add(new Profesional(rs.getInt("id_U"), rs.getString("nombre"), rs.getString("rut"), rs.getString("tipo"), rs.getInt("id_PF"), rs.getString("titulo"), rs.getString("fecha_ingreso") ));

			}
			rs.close();
			stm.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return profesional;
	}

	@Override
	public Profesional obtenerProfesionalPorId(int idPF) {
		Statement stm = null;
		ResultSet rs = null;
		String sql = "select u.id_U, u.nombre, u.rut, u.tipo, p.id_PF, p.titulo, p.fecha_ingreso from Profesional p inner join Usuario u on u.id_U = p.id_U where id_PF = '" + idPF + "';";

		Profesional profesional = new Profesional();

		try {
			conn = ConexionDB.getConn();
			System.out.println("desde DAO: " + conn);

			stm = conn.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				profesional = new Profesional(rs.getInt("id_U"), rs.getString("nombre"), rs.getString("rut"),
						rs.getString("tipo"), rs.getInt("id_PF"), rs.getString("titulo"), rs.getString("fecha_ingreso"));

			}

			rs.close();
			stm.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return profesional;
	}

}
