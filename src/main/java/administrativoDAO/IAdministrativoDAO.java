package administrativoDAO;

import java.util.List;

import modelos.Administrativo;

public interface IAdministrativoDAO {

	void agregarAdministrativo(Administrativo administrativo);
    void actualizarAdministrativo(Administrativo administrativo);
    void eliminarAdministrativo(int idAD);
    Administrativo obtenerAdministrativoPorId(int idAD);
	List<Administrativo> obtenerTodosLosAdministrativos();

	
}
