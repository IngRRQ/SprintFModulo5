package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase ConexionDB que implementa el patrón Singleton para manejar la conexión a la base de datos.
 * Permite obtener una instancia única de la conexión y reutilizarla a lo largo de la aplicación.
 * 
 * @author Ana Andrade, Carolina Diaz, Claudio Aranguiz, Lorena Suarez, Ricardo Ramones
 */
public class ConexionDB {
    private static Connection conn = null;

    /**
     * Constructor privado de la clase ConexionDB.
     * Configura la conexión a la base de datos MySQL utilizando los datos proporcionados.
     */
    private ConexionDB() {
        String url = "jdbc:mysql://localhost:3306/base";
        String driver = "com.mysql.jdbc.Driver";
        String usuario = "root";
        String contraseña = "1234";

        try {
            // Cargar el driver de MySQL
            Class.forName(driver);

            try {
                // Establecer la conexión
                setConn(DriverManager.getConnection(url, usuario, contraseña));
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Método estático que devuelve la conexión actual a la base de datos.
     * Si no existe una conexión activa, crea una nueva.
     * 
     * @return La instancia única de la conexión a la base de datos.
     */
    public static Connection getConn() {
        if (conn == null) {
            new ConexionDB();
            return conn;
        } else {
            return conn;
        }
    }

    /**
     * Método estático que establece la conexión a la base de datos.
     * 
     * @param conn La conexión a la base de datos que se desea establecer.
     */
    public static void setConn(Connection conn) {
        ConexionDB.conn = conn;
        System.out.println(conn);
    }
}
