package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CapacitacionDAO;
import modelos.Capacitacion;

/**
 * Servlet implementation class SvListarCapacitacion
 * Este servlet maneja la visualización de las capacitaciones en la aplicación.
 * Permite listar todas las capacitaciones disponibles.
 * 
 * @author Ana Andrade, Carolina Diaz, Claudio Aranguiz, Lorena Suarez, Ricardo Ramones
 */
@WebServlet("/listarcapacitacion")
public class SvListarCapacitacion extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public SvListarCapacitacion() {
        super();
    }

    /**
     * Maneja las solicitudes GET.
     * Verifica la autenticación del usuario y muestra la lista de capacitaciones si está autenticado.
     * 
     * @param request El objeto HttpServletRequest que contiene la solicitud del cliente
     * @param response El objeto HttpServletResponse que contiene la respuesta del servlet
     * @throws ServletException Si ocurre un error en el manejo del servlet
     * @throws IOException Si ocurre un error de entrada/salida
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            // No hay sesión activa, redirigir al login
            response.sendRedirect("login");
        } else {
            // El usuario está autenticado, continuar con la lógica de listar capacitaciones
            CapacitacionDAO cDAO = new CapacitacionDAO();
            List<Capacitacion> capacitaciones = cDAO.obtenerTodasLasCapacitaciones();
            request.setAttribute("capacitaciones", capacitaciones);
            getServletContext().getRequestDispatcher("/views/listarCapacitacion.jsp").forward(request, response);
        }
    }

    /**
     * Maneja las solicitudes POST.
     * En este caso, simplemente redirige a la lógica de GET.
     * 
     * @param request El objeto HttpServletRequest que contiene la solicitud del cliente
     * @param response El objeto HttpServletResponse que contiene la respuesta del servlet
     * @throws ServletException Si ocurre un error en el manejo del servlet
     * @throws IOException Si ocurre un error de entrada/salida
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirige a la lógica de GET para manejar la solicitud POST
        doGet(request, response);
    }
}
