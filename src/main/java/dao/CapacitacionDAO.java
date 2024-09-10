package dao;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.Capacitacion;
import conexion.ConexionDB;

/**
 * Implementación de la interfaz ICapacitacionDAO para manejar operaciones relacionadas con la entidad Capacitacion en la base de datos.
 * Esta clase proporciona métodos para agregar, actualizar, eliminar y obtener capacitaciones.
 * 
 * @see ICapacitacionDAO
 */
public class CapacitacionDAO implements ICapacitacionDAO {

    private Connection conn = null;

    /**
     * Agrega una nueva capacitación a la base de datos.
     * 
     * @param capacitacion El objeto Capacitacion que se va a agregar.
     */
    @Override
    public void agregarCapacitacion(Capacitacion capacitacion) {
        Statement stm = null;
        int rs = 0;
        String dia = capacitacion.getDia();
        String hora = capacitacion.getHora();
        String lugar = capacitacion.getLugar();
        String duracion = capacitacion.getDuracion();
        int cantidadAsistentes = capacitacion.getCantidadAsistentes();

        String sql = "INSERT INTO capacitacion (dia, hora, lugar, duracion, cantidad_asistentes) VALUES ('" 
                     + dia + "', '" + hora + "', '" + lugar + "', '" + duracion + "', " + cantidadAsistentes + ")";

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
     * Actualiza una capacitación existente en la base de datos.
     * 
     * @param capacitacion El objeto Capacitacion con los datos actualizados.
     */
    @Override
    public void actualizarCapacitacion(Capacitacion capacitacion) {
        // Método aún no implementado
    }

    /**
     * Elimina una capacitación de la base de datos basándose en el identificador de la capacitación.
     * 
     * @param identificador El identificador de la capacitación a eliminar.
     */
    @Override
    public void eliminarCapacitacion(int identificador) {
        // Método aún no implementado
    }

    /**
     * Obtiene todas las capacitaciones de la base de datos.
     * 
     * @return Una lista de objetos Capacitacion que representan todas las capacitaciones en la base de datos.
     */
    @Override
    public List<Capacitacion> obtenerTodasLasCapacitaciones() {
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT identificador, dia, hora, lugar, duracion, cantidad_asistentes FROM Capacitacion;";

        List<Capacitacion> capacitaciones = new ArrayList<>();

        try {
            conn = ConexionDB.getConn();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                capacitaciones.add(new Capacitacion(rs.getInt("identificador"), rs.getString("dia"), rs.getString("hora"),
                        rs.getString("lugar"), rs.getString("duracion"), rs.getInt("cantidad_asistentes")));
            }
            rs.close();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return capacitaciones;
    }

    /**
     * Obtiene una capacitación de la base de datos basándose en el ID de la capacitación.
     * 
     * @param id El ID de la capacitación a obtener.
     * @return Un objeto Capacitacion con los datos de la capacitación correspondiente al ID proporcionado.
     */
    @Override
    public Capacitacion obtenerCapacitacionPorId(int id) {
        // Método aún no implementado
        return null;
    }
}
