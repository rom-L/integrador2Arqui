package integrador2Arqui.repositorios;

import integrador2Arqui.DTO.EstudianteDTO;
import integrador2Arqui.clases.Estudiante;
import integrador2Arqui.interfaces.RepoEstudiante;
import jakarta.persistence.EntityManager;

public class RepoEstudianteMySQL implements RepoEstudiante{
	private EntityManager manager;
	
	public RepoEstudianteMySQL(EntityManager manager) {
		this.manager = manager;
	}

	
	@Override
	public void insert(Estudiante estudiante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EstudianteDTO getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstudianteDTO getByLibreta(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstudianteDTO getByGenero(String genero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Estudiante estudiante) {
		// TODO Auto-generated method stub
		return false;
	}
}
