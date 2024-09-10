package clienteDAO;

import java.util.List;

import modelos.Cliente;

public interface IClienteDAO {

	void agregarCliente(Cliente Cliente);
    void actualizarCliente(Cliente Cliente);
    void eliminarCliente(int idU);
    Cliente obtenerClientePorId(int idCL);
	List<Cliente> obtenerTodosLosClientes();

}

	
