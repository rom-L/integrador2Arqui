package integrador2Arqui.repositorios;

import java.util.List;

import integrador2Arqui.DTO.EstudianteDTO;
import integrador2Arqui.clases.Estudiante;
import integrador2Arqui.interfaces.RepoEstudiante;
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
		TypedQuery<Estudiante> query = manager.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
		return query.getResultList();
	}

	@Override
	public EstudianteDTO getByLibreta(String numeroLibreta) {
		TypedQuery<Estudiante> query = manager
				.createQuery("SELECT e FROM Estudiante e WHERE e.numeroLibreta = :libreta", Estudiante.class);
		query.setParameter("libreta", numeroLibreta);
		return query.getSingleResult();
	}

	@Override
	public List<Estudiante> getByGenero(String genero) {
		TypedQuery<Estudiante> query = manager.createQuery("SELECT e FROM Estudiante e WHERE e.genero = :genero",
				Estudiante.class);
		query.setParameter("genero", genero);
		return query.getResultList();
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
