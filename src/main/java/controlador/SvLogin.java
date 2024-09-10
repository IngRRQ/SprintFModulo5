package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SvLogin
 * Este servlet maneja el proceso de inicio de sesión en la aplicación.
 * Permite a los usuarios ingresar proporcionando un nombre de usuario y una contraseña.
 * 
 * @author Ana Andrade, Carolina Diaz, Claudio Aranguiz, Lorena Suarez, Ricardo Ramones
 */
@WebServlet("/login")
public class SvLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Constructor del servlet SvLogin.
     * Llama al constructor de la superclase HttpServlet.
     */
    public SvLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Maneja las solicitudes GET.
     * Muestra la página de inicio de sesión.
     * 
     * @param request El objeto HttpServletRequest que contiene la solicitud del cliente
     * @param response El objeto HttpServletResponse que contiene la respuesta del servlet
     * @throws ServletException Si ocurre un error en el manejo del servlet
     * @throws IOException Si ocurre un error de entrada/salida
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/login.jsp").forward(request, response);
    }

    /**
     * Maneja las solicitudes POST.
     * Procesa el inicio de sesión, verifica las credenciales y redirige al usuario
     * a la página de contacto si las credenciales son correctas, o muestra un mensaje
     * de error en la página de inicio de sesión si son incorrectas.
     * 
     * @param request El objeto HttpServletRequest que contiene la solicitud del cliente
     * @param response El objeto HttpServletResponse que contiene la respuesta del servlet
     * @throws ServletException Si ocurre un error en el manejo del servlet
     * @throws IOException Si ocurre un error de entrada/salida
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtiene los parámetros del formulario
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Verificar las credenciales
        if ("admin".equals(username) && "1234".equals(password)) {
            // Redirigir al servlet de contacto si las credenciales son correctas
            request.setAttribute("message", "Usuario ingresado exitosamente.");
            request.setAttribute("messageType", "success");
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            getServletContext().getRequestDispatcher("/views/contacto.jsp").forward(request, response);

        } else {
            // Volver al formulario de login si las credenciales son incorrectas
            request.setAttribute("message", "Usuario o contraseña inválidos.");
            request.setAttribute("messageType", "danger");
            getServletContext().getRequestDispatcher("/views/login.jsp").forward(request, response);
        }
    }
}
