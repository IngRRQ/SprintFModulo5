package capacitacionDAO;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Capacitacion;
import conexion.*;

public class CapacitacionDAO implements ICapacitacionDAO {

	private Connection conn = null;

	@Override
    public void agregarCapacitacion(Capacitacion capacitacion) {
    	 Statement stm = null;
    	 int rs = 0;
    	 
    	String dia= capacitacion.getDia();
    	String hora= capacitacion.getHora();
    	String lugar= capacitacion.getLugar();
    	String duracion= capacitacion.getDuracion();
    	int cantidadAsistentes= capacitacion.getCantidadAsistentes();
    	String sql = "INSERT INTO capacitacion (dia, hora, lugar, duracion, cantidad_asistentes) VALUES ('"+dia+"', '"+hora+"', '"+lugar+"', '"+duracion+"', "+cantidadAsistentes+")";
    	 
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
	public void actualizarCapacitacion(Capacitacion Capacitacion) {
// TODO Auto-generated method stub

	}

	@Override
	public void eliminarCapacitacion(int identificador) {
		// TODO Auto-generated method stub

	}

	public List<Capacitacion> obtenerTodasLasCapacitaciones() {

		Statement stm = null;
		ResultSet rs = null;

		String sql = "select identificador, dia, hora, lugar, duracion, cantidad_asistentes from Capacitacion;";

		List<Capacitacion> capacitaciones = new ArrayList<Capacitacion>();

		try {
			conn = ConexionDB.getConn();
			System.out.println("desde DAO: " + conn);

			stm = conn.createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				capacitaciones
						.add(new Capacitacion(rs.getInt("identificador"), rs.getString("dia"), rs.getString("hora"),
								rs.getString("lugar"), rs.getString("duracion"), rs.getInt("cantidad_asistentes")));

			}
			rs.close();
			stm.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return capacitaciones;
	}

	@Override
	public Capacitacion obtenerCapacitacionPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}