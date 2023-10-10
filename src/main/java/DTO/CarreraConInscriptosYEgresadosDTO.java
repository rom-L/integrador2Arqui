package DTO;

import java.util.HashMap;
import java.util.List;

public class CarreraConInscriptosYEgresadosDTO {
	private String nombre;
	private HashMap<Integer, List<EstudianteDTO>> estudiantesInscriptosPorAnio;
	private HashMap<Integer, List<EstudianteDTO>> estudiantesGraduadosPorAnio;

	public CarreraConInscriptosYEgresadosDTO(String nombre) {
		this.nombre = nombre;
		this.estudiantesInscriptosPorAnio = new HashMap<>();
		this.estudiantesGraduadosPorAnio = new HashMap<>();
	}

	public String getNombre() {
		return nombre;
	}

	public HashMap<Integer, List<EstudianteDTO>> getEstudiantesInscriptosPorAnio() {
		return estudiantesInscriptosPorAnio;
	}

	public HashMap<Integer, List<EstudianteDTO>> getEstudiantesGraduadosPorAnio() {
		return estudiantesGraduadosPorAnio;
	}

	public void agregarInscriptosEnAnio(List<EstudianteDTO> inscriptos, Integer anio){
		this.estudiantesInscriptosPorAnio.put(anio, inscriptos);
	}

	public void agregarGraduadosEnAnio(List<EstudianteDTO> egresados, Integer anio){
		this.estudiantesGraduadosPorAnio.put(anio, egresados);
	}

	@Override
	public String toString() {
		return "CarreraConInscriptosYEgresadosDTO{" +
				"nombre='" + nombre + '\'' +
				", estudiantesInscriptosPorAnio=" + estudiantesInscriptosPorAnio +
				", estudiantesGraduadosPorAnio=" + estudiantesGraduadosPorAnio +
				'}';
	}
}
