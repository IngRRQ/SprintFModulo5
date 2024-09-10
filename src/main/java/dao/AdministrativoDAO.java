package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionDB;
import modelos.Administrativo;

/**
 * Implementación de la interfaz IAdministrativoDAO para manejar operaciones relacionadas con la entidad Administrativo en la base de datos.
 * Esta clase proporciona métodos para agregar, actualizar, eliminar y obtener administrativos.
 * 
 * @see IAdministrativoDAO
 */
public class AdministrativoDAO implements IAdministrativoDAO {

    private Connection conn = null;

    /**
     * Agrega un nuevo administrativo a la base de datos.
     * 
     * @param administrativo El objeto Administrativo que se va a agregar.
     */
    @Override
    public void agregarAdministrativo(Administrativo administrativo) {
        Statement stm = null;
        int rs = 0;
        String area = administrativo.getArea();
        String experienciaPrevia = administrativo.getExperienciaPrevia();
        int id_U = administrativo.getId();

        String sql = "INSERT INTO administrativo (area, experiencia_previa, id_U) VALUES ('" + area + "', '" + experienciaPrevia + "', " + id_U + ")";

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
     * Actualiza los datos de un administrativo existente en la base de datos.
     * 
     * @param administrativo El objeto Administrativo con los datos actualizados.
     */
    @Override
    public void actualizarAdministrativo(Administrativo administrativo) {
        Statement stm = null;
        int rs = 0;
        String nombre = administrativo.getNombre();
        String rut = administrativo.getRut();
        String area = administrativo.getArea();
        String experienciaPrevia = administrativo.getExperienciaPrevia();
        int id_AD = administrativo.getIdAD();
        int id_U = administrativo.getId();

        String sql1 = "UPDATE administrativo SET area = '" + area + "', experiencia_previa = '" + experienciaPrevia + "' WHERE id_AD = " + id_AD + ";";
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
     * Elimina un administrativo de la base de datos basándose en el ID del usuario.
     * 
     * @param idU El ID del usuario del administrativo a eliminar.
     */
    @Override
    public void eliminarAdministrativo(int idU) {
        Statement stm = null;
        int rs = 0;
        String sql = "DELETE FROM Usuario WHERE id_U =" + idU + ";";

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
     * Obtiene un administrativo de la base de datos basándose en el ID del administrativo.
     * 
     * @param idAD El ID del administrativo a obtener.
     * @return Un objeto Administrativo con los datos del administrativo correspondiente al ID proporcionado.
     */
    @Override
    public Administrativo obtenerAdministrativoPorId(int idAD) {
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT u.id_U, u.nombre, u.rut, u.tipo, a.id_AD, a.area, a.experiencia_previa "
                + "FROM Administrativo a "
                + "INNER JOIN Usuario u ON u.id_U = a.id_U "
                + "WHERE id_AD = '" + idAD + "';";

        Administrativo administrativo = new Administrativo();

        try {
            conn = ConexionDB.getConn();
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

    /**
     * Obtiene todos los administrativos de la base de datos.
     * 
     * @return Una lista de objetos Administrativo que representan todos los administrativos en la base de datos.
     */
    @Override
    public List<Administrativo> obtenerTodosLosAdministrativos() {
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT u.id_U, u.nombre, u.rut, u.tipo, a.id_AD, a.area, a.experiencia_previa "
                + "FROM Administrativo a "
                + "INNER JOIN usuario u ON a.id_U = u.id_U;";

        List<Administrativo> administrativos = new ArrayList<Administrativo>();

        try {
            conn = ConexionDB.getConn();
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                administrativos.add(new Administrativo(rs.getInt("id_U"), rs.getString("nombre"), rs.getString("rut"), rs.getString("tipo"), rs.getInt("id_AD"), rs.getString("area"), rs.getString("experiencia_previa")));
            }
            rs.close();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return administrativos;
    }
}
