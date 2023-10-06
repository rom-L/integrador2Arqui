package integrador2Arqui.interfaces;

import integrador2Arqui.DTO.EstudianteDTO;
import integrador2Arqui.clases.Estudiante;

public interface RepoEstudiante {
	public void insert(Estudiante estudiante);
	public EstudianteDTO getAll();
	public EstudianteDTO getByLibreta(int id);
	public EstudianteDTO getByGenero(String genero);
	public boolean delete(int id);
	public boolean update(Estudiante estudiante);
}
