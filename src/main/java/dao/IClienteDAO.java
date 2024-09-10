package dao;

import java.util.List;
import modelos.Cliente;

/**
 * Interfaz para manejar operaciones relacionadas con la entidad Cliente en la base de datos.
 * Esta interfaz define los métodos necesarios para realizar operaciones CRUD (crear, leer, actualizar y eliminar)
 * sobre los registros de clientes.
 */
public interface IClienteDAO {

    void agregarCliente(Cliente cliente);
    void actualizarCliente(Cliente cliente);
    void eliminarCliente(int idU);
    Cliente obtenerClientePorId(int idCL);
    List<Cliente> obtenerTodosLosClientes();
}
