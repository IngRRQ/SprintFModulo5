package administrativoDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionDB;
import modelos.Administrativo;

public class AdministrativoDAO implements IAdministrativoDAO{

	private Connection conn = null;
		
		@Override
		public void agregarAdministrativo(Administrativo administrativo) {
			
			 Statement stm = null;
	    	 
	    	 int rs = 0;
	    	 
	    	 String area= administrativo.getArea();
	    	 String experienciaPrevia= administrativo.getExperienciaPrevia();
	    	 int id_U = administrativo.getId();
	   

	    	String sql = "INSERT INTO administrativo (area, experiencia_previa, id_U) VALUES ('"+area+"', '"+experienciaPrevia+"', "+id_U+")";
	    	 
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
	    public void actualizarAdministrativo(Administrativo administrativo) {
			 Statement stm = null;
	    	 int rs = 0;
	    	 
	    	 String nombre = administrativo.getNombre();
	    	 String rut = administrativo.getRut();
	    	 String area= administrativo.getArea();
	    	 String experienciaPrevia= administrativo.getExperienciaPrevia();
	    	 int id_AD = administrativo.getIdAD();
	    	 int id_U = administrativo.getId();	    	 

	    	 String sql1 = "UPDATE administrativo SET area = '" + area + "', experiencia_previa = '" + experienciaPrevia + "' WHERE id_AD = " + id_AD + ";";
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
	    public void eliminarAdministrativo(int idU) {
			Statement stm = null;
	    	int rs = 0;
	    	
	    	String sql = "DELETE FROM Usuario WHERE id_U =" + idU+";";
	    	
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
	    public Administrativo obtenerAdministrativoPorId(int idAD) {
			Statement stm = null;
			ResultSet rs = null;
			String sql = "select u.id_U, u.nombre, u.rut, u.tipo, a.id_AD, a.area, a.experiencia_previa from Administrativo a inner join Usuario u on u.id_U = a.id_U where id_AD = '" + idAD + "';";

			Administrativo administrativo = new Administrativo();

			try {
				conn = ConexionDB.getConn();
				System.out.println("desde DAO: " + conn);

				stm = conn.createStatement();
				rs = stm.executeQuery(sql);

				while (rs.next()) {
					administrativo = new Administrativo(rs.getInt("id_U"), rs.getString("nombre"), rs.getString("rut"),
							rs.getString("tipo"), rs.getInt("id_AD"), rs.getString("area"), rs.getString("experiencia_previa"));

				}

				rs.close();
				stm.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return administrativo;
	    }
		
		@Override
		public List<Administrativo> obtenerTodosLosAdministrativos(){
			Statement stm = null;
			ResultSet rs = null;

			String sql = "select u.id_U, u.nombre, u.rut, u.tipo, a.id_AD, a.area, a.experiencia_previa from Administrativo a inner join usuario u on a.id_U = u.id_U;";

			List<Administrativo> administrativo = new ArrayList<Administrativo>();

			try {
				conn = ConexionDB.getConn();
				System.out.println("desde DAO: " + conn);

				stm = conn.createStatement();
				rs = stm.executeQuery(sql);

				while (rs.next()) {
					administrativo
					.add(new Administrativo(rs.getInt("id_U"), rs.getString("nombre"), rs.getString("rut"), rs.getString("tipo"), rs.getInt("id_AD"), rs.getString("area"), rs.getString("experiencia_previa") ));

				}
				rs.close();
				stm.close();


			} catch (SQLException e) {
				e.printStackTrace();
			}

			return administrativo;
		}
	}

