package profesionalDAO;

import java.util.List;

import modelos.Profesional;

public interface IProfesionalDAO {

	void agregarProfesional(Profesional profesional);
    void actualizarProfesional(Profesional profesional);
    void eliminarProfesional(int idPF);
    Profesional obtenerProfesionalPorId(int idPF);
	List<Profesional> obtenerTodosLosProfesionales();
	
}
