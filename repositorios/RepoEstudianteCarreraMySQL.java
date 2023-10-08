package integrador2Arqui.repositorios;

import java.util.List;

import integrador2Arqui.DTO.CarreraDTO;
import integrador2Arqui.DTO.EstudianteDTO;
import integrador2Arqui.DTO.ReporteDTO;
import integrador2Arqui.clases.Carrera;
import integrador2Arqui.clases.Estudiante;
import integrador2Arqui.interfaces.RepoEstudianteCarrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class RepoEstudianteCarreraMySQL implements RepoEstudianteCarrera {
	private EntityManager manager;
	
	public RepoEstudianteCarreraMySQL(EntityManager manager) {
		this.manager = manager;
	}

	
	@Override
    public void matricular(Estudiante estudiante, Carrera carrera) {
        estudiante.addCarrera(carrera);
        manager.merge(estudiante);
    }

	//REVISAR
    @Override
    public CarreraDTO getCarrerasConInscriptos() {
        // Retrieve a list of CarreraConInscriptosDTO objects (courses with enrolled students), sorted by the number of inscriptos
        Query query = manager.createQuery("SELECT NEW integrador2Arqui.DTO.CarreraDTO(c, c.estudiantes.size()) FROM Carrera c ORDER BY c.estudiantes.size() DESC");
        List<CarreraDTO> carrerasConInscriptos = query.getResultList();
        return new CarreraDTO(carrerasConInscriptos);
    }

    //REVISAR
    @Override
    public EstudianteDTO getEstudiantesByCarrera(Carrera carrera, String ciudadResidencia) {
        // Retrieve an EstudianteDTO object (students enrolled in a specific course and filtered by ciudadResidencia)
        Query query = manager.createQuery("SELECT NEW integrador2Arqui.DTO.EstudianteDTO(e) FROM Estudiante e JOIN e.carreras c WHERE c.id = :carreraId AND e.ciudadResidencia = :ciudadResidencia");
        query.setParameter("carreraId", carrera.getId());
        query.setParameter("ciudadResidencia", ciudadResidencia);
        List<EstudianteDTO> estudiantesByCarrera = query.getResultList();
        return new EstudianteDTO(estudiantesByCarrera);
    }
    
    //REVISAR
    @Override
    public ReporteDTO getReporteCarreras() {
        // Retrieve a list of Carrera objects, sorted alphabetically by nombre
        Query query = manager.createQuery("SELECT c FROM Carrera c ORDER BY c.nombre ASC");
        List<Carrera> carreras = query.getResultList();

        // Implement your custom logic to organize the years chronologically for each Carrera
        // For example, you can have a Map<Carrera, List<Year>> where the keys are Carrera objects, 
        // and the values are lists of years representing the chronological order.

        // Create a ReporteDTO object based on the sorted Carrera list and organized years
        return new ReporteDTO(carreras, yearsMap);
    }


	@Override
	public EstudianteDTO getEstudiantesByCarrera(Carrera carrera) {
		// TODO Auto-generated method stub
		return null;
	}

}