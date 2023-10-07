package integrador2Arqui.repositorios;

import integrador2Arqui.DTO.CarreraConInscriptosDTO;
import integrador2Arqui.DTO.EstudianteDTO;
import integrador2Arqui.DTO.ReporteDTO;
import integrador2Arqui.clases.Carrera;
import integrador2Arqui.clases.Estudiante;
import integrador2Arqui.interfaces.RepoEstudianteCarrera;
import jakarta.persistence.EntityManager;

public class RepoEstudianteCarreraMySQL implements RepoEstudianteCarrera {
	private EntityManager manager;
	
	public RepoEstudianteCarreraMySQL(EntityManager manager) {
		this.manager = manager;
	}

	
	@Override
	public void insert(Estudiante estudiante, Carrera carrera) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CarreraConInscriptosDTO getCarrerasConInscriptos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstudianteDTO getEstudiantesByCarrera(Carrera carrera) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReporteDTO getReporteCarreras() {
		// TODO Auto-generated method stub
		return null;
	}
}
