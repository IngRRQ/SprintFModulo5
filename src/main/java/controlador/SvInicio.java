package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SvInicio
 * Este servlet maneja las solicitudes GET y POST para la página de inicio.
 * Sirve la vista de inicio a los usuarios que visitan la aplicación.
 * 
 * @author Ana Andrade, Carolina Diaz, Claudio Aranguiz, Lorena Suarez, Ricardo Ramones
 */
@WebServlet("/inicio")
public class SvInicio extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * Constructor del servlet SvInicio.
     * Llama al constructor de la superclase HttpServlet.
     */
    public SvInicio() {
        super();
    }

    /**
     * Maneja las solicitudes GET.
     * Redirige al usuario a la vista de inicio.
     * 
     * @param request El objeto HttpServletRequest que contiene la solicitud del cliente
     * @param response El objeto HttpServletResponse que contiene la respuesta del servlet
     * @throws ServletException Si ocurre un error en el manejo del servlet
     * @throws IOException Si ocurre un error de entrada/salida
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/inicio.jsp").forward(request, response);
    }

    /**
     * Maneja las solicitudes POST.
     * Reutiliza la lógica del método doGet para redirigir al usuario a la vista de inicio.
     * 
     * @param request El objeto HttpServletRequest que contiene la solicitud del cliente
     * @param response El objeto HttpServletResponse que contiene la respuesta del servlet
     * @throws ServletException Si ocurre un error en el manejo del servlet
     * @throws IOException Si ocurre un error de entrada/salida
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

