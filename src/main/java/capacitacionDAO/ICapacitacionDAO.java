package capacitacionDAO;

import java.util.List;

import modelos.Capacitacion;

public interface ICapacitacionDAO {

	void agregarCapacitacion(Capacitacion capacitacion);
	void actualizarCapacitacion(Capacitacion Capacitacion);
	void eliminarCapacitacion(int identificador);
	Capacitacion obtenerCapacitacionPorId(int id);
	List<Capacitacion> obtenerTodasLasCapacitaciones();

}
