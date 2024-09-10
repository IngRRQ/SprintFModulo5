package controlador;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class SvListadoUsuarios
 * Este servlet maneja la visualización y gestión de usuarios en la aplicación.
 * Permite listar todos los usuarios y realizar operaciones de eliminación y actualización.
 * 
 * @author Ana Andrade, Carolina Diaz, Claudio Aranguiz, Lorena Suarez, Ricardo Ramones
 */
@WebServlet("/listadodeusuarios")
public class SvListadoUsuarios extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SvListadoUsuarios() {
        super();
    }

    /**
     * Maneja las solicitudes GET.
     * Verifica la autenticación del usuario y muestra la lista de usuarios si está autenticado.
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
            // El usuario está autenticado, continuar con la lógica de listar usuarios
            // Inicialización de DAOs para obtener listas de usuarios
            UsuarioDAO uDAO = new UsuarioDAO();
            ClienteDAO clDAO = new ClienteDAO();
            ProfesionalDAO pDAO = new ProfesionalDAO();
            AdministrativoDAO aDAO = new AdministrativoDAO();

            List<Usuario> usuarios = uDAO.obtenerTodosLosUsuarios();
            List<Cliente> clientes = clDAO.obtenerTodosLosClientes();
            List<Profesional> profesionales = pDAO.obtenerTodosLosProfesionales();
            List<Administrativo> administrativos = aDAO.obtenerTodosLosAdministrativos();

            request.setAttribute("usuarios", usuarios);
            request.setAttribute("clientes", clientes);
            request.setAttribute("profesionales", profesionales);
            request.setAttribute("administrativos", administrativos);

            getServletContext().getRequestDispatcher("/views/listadodeusuarios.jsp").forward(request, response);
        }
    }

    /**
     * Maneja las solicitudes POST.
     * Permite realizar operaciones de eliminación y actualización de usuarios según el tipo y acción especificada.
     * 
     * @param request El objeto HttpServletRequest que contiene la solicitud del cliente
     * @param response El objeto HttpServletResponse que contiene la respuesta del servlet
     * @throws ServletException Si ocurre un error en el manejo del servlet
     * @throws IOException Si ocurre un error de entrada/salida
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Recepción de datos mediante POST y eliminación o actualización según tipo
        ClienteDAO clDAO = new ClienteDAO();
        ProfesionalDAO pDAO = new ProfesionalDAO();
        AdministrativoDAO aDAO = new AdministrativoDAO();

        int id = Integer.parseInt(request.getParameter("id"));
        String tipo = request.getParameter("tipo");
        String action = request.getParameter("action");

        if (action.equals("borrar")) {
            switch (tipo) {
                case "Administrativo":
                    aDAO.eliminarAdministrativo(id);
                    break;
                case "Cliente":
                    clDAO.eliminarCliente(id);
                    break;
                case "Profesional":
                    pDAO.eliminarProfesional(id);
                    break;
            }
            // Retiene la sesión después de borrar un usuario
            HttpSession session = request.getSession(false);
            response.sendRedirect("listadodeusuarios");
        } else {
            // Lógica para actualizar los datos de un usuario
            switch (tipo) {
                case "Administrativo":
                    Administrativo updateAdministrativo = aDAO.obtenerAdministrativoPorId(id);
                    updateAdministrativo.setNombre(request.getParameter("nombre"));
                    updateAdministrativo.setRut(request.getParameter("rut"));
                    updateAdministrativo.setArea(request.getParameter("area"));
                    updateAdministrativo.setExperienciaPrevia(request.getParameter("experienciaPrevia"));
                    aDAO.actualizarAdministrativo(updateAdministrativo);
                    break;
                case "Cliente":
                    Cliente updateCliente = clDAO.obtenerClientePorId(id);
                    updateCliente.setNombre(request.getParameter("nombre"));
                    updateCliente.setRut(request.getParameter("rut"));
                    updateCliente.setTelefono(request.getParameter("telefono"));
                    updateCliente.setComuna(request.getParameter("comuna"));
                    clDAO.actualizarCliente(updateCliente);
                    break;
                case "Profesional":
                    Profesional updateProfesional = pDAO.obtenerProfesionalPorId(id);
                    updateProfesional.setNombre(request.getParameter("nombre"));
                    updateProfesional.setRut(request.getParameter("rut"));
                    updateProfesional.setTitulo(request.getParameter("titulo"));
                    updateProfesional.setFechaIngreso(request.getParameter("fechaIngreso"));
                    pDAO.actualizarProfesional(updateProfesional);
                    break;
            }
            // Redirige al listado de usuarios
            HttpSession session = request.getSession(false);
            response.sendRedirect("listadodeusuarios");
        }
    }

}
