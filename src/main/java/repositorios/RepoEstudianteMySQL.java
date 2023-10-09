package repositorios;

import java.util.ArrayList;

import java.util.List;

import DTO.EstudianteDTO;
import clases.Estudiante;
import interfaces.RepoEstudiante;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class RepoEstudianteMySQL implements RepoEstudiante {
	private EntityManager manager;

	public RepoEstudianteMySQL(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void insert(Estudiante estudiante) {
		manager.getTransaction().begin();
		manager.persist(estudiante);
		manager.getTransaction().commit();
	}

	@Override
	public List<EstudianteDTO> getAll() {
		TypedQuery<Estudiante> query = manager.createQuery("SELECT e FROM Estudiante e ORDER BY e.dni DESC",
				Estudiante.class);
		List<Estudiante> estudiantes = query.getResultList();
		List<EstudianteDTO> estudiantesDTO = new ArrayList<EstudianteDTO>();
		for (Estudiante estudiante : estudiantes) {
			EstudianteDTO estudianteDTO = new EstudianteDTO(estudiante.getDni(), estudiante.getNombres(),
					estudiante.getApellido(), estudiante.getEdad(), estudiante.getGenero(),
					estudiante.getCiudadResidencia(), estudiante.getNumeroLibreta());
			estudiantesDTO.add(estudianteDTO);
		}
		return estudiantesDTO;
	}

	@Override
	public EstudianteDTO getByLibreta(int numeroLibreta) {
		TypedQuery<Estudiante> query = manager
				.createQuery("SELECT e FROM Estudiante e WHERE e.numeroLibreta = :libreta", Estudiante.class);
		query.setParameter("libreta", numeroLibreta);
		Estudiante estudiante = query.getSingleResult();
		EstudianteDTO estudianteDTO = new EstudianteDTO(estudiante.getDni(), estudiante.getNombres(),
				estudiante.getApellido(), estudiante.getEdad(), estudiante.getGenero(),
				estudiante.getCiudadResidencia(), estudiante.getNumeroLibreta());
		return estudianteDTO;
	}

	@Override
	public List<EstudianteDTO> getAllByGenero(String genero) {
		TypedQuery<Estudiante> query = manager.createQuery("SELECT e FROM Estudiante e WHERE e.genero = :genero",
				Estudiante.class);
		query.setParameter("genero", genero);
		List<Estudiante> estudiantes = query.getResultList();
		List<EstudianteDTO> estudiantesDTO = new ArrayList<EstudianteDTO>();
		for (Estudiante estudiante : estudiantes) {
			EstudianteDTO estudianteDTO = new EstudianteDTO(estudiante.getDni(), estudiante.getNombres(),
					estudiante.getApellido(), estudiante.getEdad(), estudiante.getGenero(),
					estudiante.getCiudadResidencia(), estudiante.getNumeroLibreta());
			estudiantesDTO.add(estudianteDTO);
		}
		return estudiantesDTO;
	}

	@Override
	public boolean delete(int id) {
		manager.getTransaction().begin();
		Estudiante estudiante = manager.find(Estudiante.class, id);
		if (estudiante != null) {
			manager.remove(estudiante);
			manager.getTransaction().commit();
			return true;
		} else {
			manager.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public boolean update(Estudiante estudiante) {
		manager.getTransaction().begin();
		manager.merge(estudiante);
		manager.getTransaction().commit();
		return true;
	}

}
