package integrador2Arqui.interfaces;

import integrador2Arqui.DTO.estudianteDTO;
import integrador2Arqui.clases.Estudiante;

public interface RepoEstudiante {
	public void insert(Estudiante estudiante);
	public estudianteDTO getAll();
	public estudianteDTO getByLibreta(int id);
	public estudianteDTO getByGenero(String genero);
	public boolean delete(int id);
	public boolean update(Estudiante estudiante);
}
