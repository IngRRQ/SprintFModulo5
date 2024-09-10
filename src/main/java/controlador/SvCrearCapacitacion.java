package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CapacitacionDAO;
import modelos.Capacitacion;

/**
 * Servlet implementation class SvCrearCapacitacion
 * Este servlet maneja las solicitudes GET y POST para la vista de creación de capacitaciones.
 * Permite a los usuarios autenticados acceder al formulario para crear una capacitación y 
 * registra la capacitación en la base de datos.
 * 
 * @author Ana Andrade, Carolina Diaz, Claudio Aranguiz, Lorena Suarez, Ricardo Ramones
 */
@WebServlet("/crearcapacitacion")
public class SvCrearCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public SvCrearCapacitacion() {
        super();
    }

    /**
     * Verifica que el usuario esté autenticado. Si no está autenticado, redirige al login.
     * Si el usuario está autenticado, muestra la vista para crear una capacitación.
     * 
     * @param request El objeto HttpServletRequest que contiene la solicitud del cliente
     * @param response El objeto HttpServletResponse que contiene la respuesta del servlet
     * @throws ServletException Si ocurre un error en el manejo del servlet
     * @throws IOException Si ocurre un error de entrada/salida
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("login");
        } else {
            // El usuario está autenticado, continuar con la lógica de crear capacitación
            getServletContext().getRequestDispatcher("/views/crearCapacitacion.jsp").forward(request, response);
        }
    }


    /**
     * Captura los datos del formulario de capacitación, crea un objeto de capacitación con esos datos,
     * y registra la capacitación en la base de datos.
     * Luego muestra un mensaje de éxito en la vista de creación de capacitación.
     * 
     * @param request El objeto HttpServletRequest que contiene la solicitud del cliente
     * @param response El objeto HttpServletResponse que contiene la respuesta del servlet
     * @throws ServletException Si ocurre un error en el manejo del servlet
     * @throws IOException Si ocurre un error de entrada/salida
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Código para recibir los datos que el cliente ingresa en el formulario de capacitación
        String dia = request.getParameter("dia");
        String hora = request.getParameter("hora");
        String lugar = request.getParameter("lugar");
        String duracion = request.getParameter("duracion");
        String cantidadAsistentes = request.getParameter("cantidadAsistentes");
        int cantidadAsistentesInt = Integer.parseInt(cantidadAsistentes); 
        
        // Creación de objeto capacitación con los datos entregados por el cliente
        Capacitacion capacitacion = new Capacitacion(0, dia, hora, lugar, duracion, cantidadAsistentesInt);

        // Llamado al método registrarCapacitacion
        CapacitacionDAO cDAO = new CapacitacionDAO();
        cDAO.agregarCapacitacion(capacitacion);
        
        // Entregar mensaje de registro exitoso luego de llamado al método
        request.setAttribute("message", "¡Su capacitación fue registrada exitosamente!");
        getServletContext().getRequestDispatcher("/views/crearCapacitacion.jsp").forward(request, response);
    }
}