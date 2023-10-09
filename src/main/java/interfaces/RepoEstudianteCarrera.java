package interfaces;

import DTO.CarreraDTO;
import DTO.EstudianteDTO;
import DTO.ReporteDTO;
import clases.Carrera;
import clases.Estudiante;

import java.util.List;

public interface RepoEstudianteCarrera {
	public void matricular(Estudiante estudiante, Carrera carrera);	//matricula un estudiante a una carrera
	public List<CarreraDTO> getCarrerasConInscriptos();	/**ORDENAR POR CANT. INSCRIPTOS**/
	public List<EstudianteDTO> getEstudiantesByCarrera(Carrera carrera, String ciudadResidencia); /**FILTRAR POR CIUDAD DE RESIDENCIA**/
	public List<ReporteDTO> getReportes(); /**ordenar las carreras alfabéticamente, y presentar los años de manera cronológica**/
}
