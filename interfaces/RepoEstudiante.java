package integrador2Arqui.interfaces;

import java.util.List;

import integrador2Arqui.DTO.EstudianteDTO;
import integrador2Arqui.clases.Estudiante;

public interface RepoEstudiante {
	public void insert(Estudiante estudiante);
	public List<EstudianteDTO> getAll();	/**ORDENAR DE ALGUNA MANERA**/
	public EstudianteDTO getByLibreta(String libreta);
	public EstudianteDTO getByGenero(String genero);
	public boolean delete(int id);
	public boolean update(Estudiante estudiante);
}
