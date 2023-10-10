package interfaces;

import DTO.CarreraConInscriptosYEgresadosDTO;
import DTO.EstudianteDTO;
import DTO.ReporteDTO;
import clases.Carrera;
import clases.Estudiante;

import java.util.List;

public interface RepoMatriculacion {
	public void matricular(Estudiante estudiante, Carrera carrera, int anioInscripcion, Integer anioGraduacion, int antiguedad);	//matricula un estudiante a una carrera
	public List<CarreraConInscriptosYEgresadosDTO> getCarrerasConInscriptosDescendentemente();	/**ORDENAR POR CANT. INSCRIPTOS**/
	public List<EstudianteDTO> getEstudiantesByCarreraAndCiudadResidencia(Carrera carrera, String ciudadResidencia); /**FILTRAR POR CIUDAD DE RESIDENCIA**/
	public ReporteDTO getReporte(); /**ordenar las carreras alfabéticamente, y presentar los años de manera cronológica**/
}
