package interfaces;

import DTO.EstudianteDTO;
import clases.Estudiante;

import java.util.List;

public interface RepoEstudiante {
	public void insert(Estudiante estudiante);
	public List<EstudianteDTO> getAll();	/**ORDENAR DE ALGUNA MANERA**/
	public EstudianteDTO getByLibreta(int libreta);
	public List<EstudianteDTO> getAllByGenero(String genero);
	public boolean delete(int id);
	public boolean update(Estudiante estudiante);
}
