package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SvContacto
 * Este servlet maneja las solicitudes GET y POST para la vista de contacto.
 * Permite a los usuarios autenticados acceder al formulario de contacto y 
 * captura el mensaje enviado para mostrarlo en la consola.
 * 
 * @author Ana Andrade, Carolina Diaz, Claudio Aranguiz, Lorena Suarez, Ricardo Ramones
 */
@WebServlet("/contacto")
public class SvContacto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SvContacto() {
        super();
        
    }

	/**
	 * Solo permite a los usuarios autenticados acceder a la vista de contacto.
	 * Si no hay una sesión activa, redirige a la página de inicio de sesión.
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
		    getServletContext().getRequestDispatcher("/views/contacto.jsp").forward(request, response);
        }
	}

	/**
	 * Captura el email y el mensaje enviados a través del formulario de contacto y los muestra en la consola.
	 * También muestra un mensaje de éxito en la vista de contacto.
	 * 
	 * @param request El objeto HttpServletRequest que contiene la solicitud del cliente
	 * @param response El objeto HttpServletResponse que contiene la respuesta del servlet
	 * @throws ServletException Si ocurre un error en el manejo del servlet
	 * @throws IOException Si ocurre un error de entrada/salida
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mensaje = request.getParameter("mensaje");
		
		System.out.println(email);
		System.out.println(mensaje);
		
		request.setAttribute("messageType", "success");
		request.setAttribute("message", "¡Su mensaje fue enviado exitosamente!");
		getServletContext().getRequestDispatcher("/views/contacto.jsp").forward(request, response);
	}
}
