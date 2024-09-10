package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdministrativoDAO;
import dao.ClienteDAO;
import dao.ProfesionalDAO;
import dao.UsuarioDAO;
import modelos.Administrativo;
import modelos.Cliente;
import modelos.Profesional;
import modelos.Usuario;

/**
 * Servlet implementation class SvCrearUsuario
 * Permite a los usuarios autenticados acceder al formulario para crear un nuevo usuario
 * y registrar los datos correspondientes en la base de datos según el tipo de usuario seleccionado.
 * 
 * @author Ana Andrade, Carolina Diaz, Claudio Aranguiz, Lorena Suarez, Ricardo Ramones
 */
@WebServlet("/crearusuario")
public class SvCrearUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private AdministrativoDAO administrativoDAO = new AdministrativoDAO();
    private ClienteDAO clienteDAO = new ClienteDAO(); 
    private ProfesionalDAO profesionalDAO = new ProfesionalDAO();
    
    public SvCrearUsuario() {
        super();
        this.usuarioDAO = new UsuarioDAO();
    }

    /**
     * Verifica que el usuario esté autenticado. Si no está autenticado, redirige al login.
     * Si el usuario está autenticado, muestra la vista para crear un nuevo usuario.
     * 
     * @param request El objeto HttpServletRequest que contiene la solicitud del cliente
     * @param response El objeto HttpServletResponse que contiene la respuesta del servlet
     * @throws ServletException Si ocurre un error en el manejo del servlet
     * @throws IOException Si ocurre un error de entrada/salida
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            // No hay sesión activa, redirigir al login
            response.sendRedirect("login");
        } else {
            // El usuario está autenticado, mostrar la página de crear usuario
            request.getRequestDispatcher("/views/crearusuario.jsp").forward(request, response);
        }
    }

    /**
     * Captura los datos del formulario para crear un usuario, registra al usuario en la base de datos,
     * y según el tipo de usuario, registra los detalles adicionales (Administrativo, Cliente o Profesional).
     * 
     * @param request El objeto HttpServletRequest que contiene la solicitud del cliente
     * @param response El objeto HttpServletResponse que contiene la respuesta del servlet
     * @throws ServletException Si ocurre un error en el manejo del servlet
     * @throws IOException Si ocurre un error de entrada/salida
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Código que registra al usuario en la base de datos
        String nombre = request.getParameter("nombre");
        String rut = request.getParameter("rut");
        String tipo = request.getParameter("tipo");

        Usuario usuario = new Usuario(0, nombre, rut, tipo);
        usuarioDAO.agregarUsuario(usuario);
        int usuarioId = usuarioDAO.obtenerUsuarioPorRut(rut).getId();

        // Se agregan los atributos del tipo de usuario a la base de datos según lo que se seleccione en el formulario
        switch(tipo) {
            case "Administrativo": 
                String area = request.getParameter("area");
                String experienciaPrevia = request.getParameter("experienciaPrevia");

                Administrativo administrativo = new Administrativo(usuarioId, nombre, rut, tipo, 0, area, experienciaPrevia);
                administrativoDAO.agregarAdministrativo(administrativo);
                break;
            case "Cliente":
                String telefono = request.getParameter("telefono");
                String comuna = request.getParameter("comuna");

                Cliente cliente = new Cliente(usuarioId, nombre, rut, tipo, 0, telefono, comuna);
                clienteDAO.agregarCliente(cliente);
                break;    
            case "Profesional":
                String titulo = request.getParameter("titulo");
                String fechaIngreso = request.getParameter("fechaIngreso");

                Profesional profesional = new Profesional(usuarioId, nombre, rut, tipo, 0, titulo, fechaIngreso);
                profesionalDAO.agregarProfesional(profesional);
                break;
        }    

        // Agregar un mensaje de éxito y redirigir a la página de crear usuario
        request.setAttribute("message", "¡Su " + tipo + " fue registrado exitosamente!");
        request.getRequestDispatcher("/views/crearusuario.jsp").forward(request, response);
    }
}
