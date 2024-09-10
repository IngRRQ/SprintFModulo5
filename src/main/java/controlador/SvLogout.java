package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SvLogout
 * Este servlet maneja el proceso de cierre de sesión de los usuarios.
 * Permite a los usuarios cerrar sesión invalidando su sesión actual.
 * 
 * @author Ana Andrade, Carolina Diaz, Claudio Aranguiz, Lorena Suarez, Ricardo Ramones
 */
@WebServlet("/logout")
public class SvLogout extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Maneja las solicitudes GET.
     * Invalida la sesión actual si existe y redirige al usuario a la página de inicio de sesión.
     * 
     * @param request El objeto HttpServletRequest que contiene la solicitud del cliente
     * @param response El objeto HttpServletResponse que contiene la respuesta del servlet
     * @throws ServletException Si ocurre un error en el manejo del servlet
     * @throws IOException Si ocurre un error de entrada/salida
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener la sesión actual, si existe
        HttpSession session = request.getSession(false);

        if (session != null) {
            // Invalidar la sesión
            session.invalidate();
        }

        // Redirigir al usuario a la página de login
        response.sendRedirect("login");
    }

    /**
     * Maneja las solicitudes POST.
     * Redirige a la lógica de manejo de solicitudes GET para cerrar sesión.
     * 
     * @param request El objeto HttpServletRequest que contiene la solicitud del cliente
     * @param response El objeto HttpServletResponse que contiene la respuesta del servlet
     * @throws ServletException Si ocurre un error en el manejo del servlet
     * @throws IOException Si ocurre un error de entrada/salida
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
