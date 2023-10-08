package integrador2Arqui.interfaces;

import java.util.List;

import integrador2Arqui.DTO.CarreraDTO;
import integrador2Arqui.DTO.EstudianteDTO;
import integrador2Arqui.DTO.ReporteDTO;
import integrador2Arqui.clases.Carrera;
import integrador2Arqui.clases.Estudiante;

public interface RepoEstudianteCarrera {
	public void matricular(Estudiante estudiante, Carrera carrera);	//matricula un estudiante a una carrera
	public List<CarreraDTO> getCarrerasConInscriptos();	/**ORDENAR POR CANT. INSCRIPTOS**/
	public List<EstudianteDTO> getEstudiantesByCarrera(Carrera carrera, String ciudadResidencia); /**FILTRAR POR CIUDAD DE RESIDENCIA**/
	public ReporteDTO getReporteCarreras(); /**ordenar las carreras alfabéticamente, y presentar los años de manera cronológica**/
}
