package integrador2Arqui.repositorios;

import java.util.ArrayList;
import java.util.List;

import integrador2Arqui.DTO.CarreraDTO;
import integrador2Arqui.DTO.EstudianteDTO;
import integrador2Arqui.DTO.ReporteDTO;
import integrador2Arqui.clases.Carrera;
import integrador2Arqui.clases.Estudiante;
import integrador2Arqui.interfaces.RepoEstudianteCarrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

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
    public List<CarreraDTO> getCarrerasConInscriptos() {
        TypedQuery<Carrera> query = manager.createQuery("SELECT c FROM Carrera c ORDER BY c.estudiantes.size() DESC", Carrera.class);
        List<Carrera> carreras = query.getResultList();
		List<CarreraDTO> carrerasDTO = new ArrayList<CarreraDTO>();
		for (Carrera carrera : carreras) {
			CarreraDTO carreraDTO = new CarreraDTO(carrera.getId(), carrera.getNombre());
			carrerasDTO.add(carreraDTO);
		}
		return carrerasDTO;
    }

    //REVISAR
    @Override
    public List<EstudianteDTO> getEstudiantesByCarrera(Carrera carrera, String ciudadResidencia) {
        TypedQuery<Estudiante> query = manager.createQuery("SELECT e FROM Estudiante e JOIN e.carreras c WHERE c.id = :carreraId AND e.ciudadResidencia = :ciudadResidencia", Estudiante.class);
        query.setParameter("carreraId", carrera.getId());
        query.setParameter("ciudadResidencia", ciudadResidencia);
        List<Estudiante> estudiantes = query.getResultList();
		List<EstudianteDTO> estudiantesDTO = new ArrayList<EstudianteDTO>();
		for (Estudiante estudiante : estudiantes) {
			EstudianteDTO estudianteDTO = new EstudianteDTO(estudiante.getDni(), estudiante.getNombres(), 
															estudiante.getApellido(), estudiante.getEdad(), 
															estudiante.getGenero(), estudiante.getCiudadResidencia(), 
															estudiante.getNumeroLibreta());
			estudiantesDTO.add(estudianteDTO);
		}
		return estudiantesDTO;
    }
    
    //REVISAR
    @Override
    public ReporteDTO getReporteCarreras() {
        // Retrieve a list of Carrera objects, sorted alphabetically by nombre
        Query query = manager.createQuery(
						        		"SELECT c.nombre AS Carrera, e.anno AS Anno \r\n"
						        		+ "SUM(e.graduado = 0) AS Inscritos,\r\n"
						        		+ "SUM(e.graduado = 1) AS Egresados\r\n"
						        		+ "FROM carrera c\r\n"
						        		+ "LEFT JOIN\r\n"
						        		+ "    EstudianteCarrera ec ON c.id = ec.carrera_id\r\n"
						        		+ "LEFT JOIN\r\n"
						        		+ "    estudiante e ON ec.estudiante_id = e.id\r\n"
						        		+ "GROUP BY\r\n"
						        		+ "    c.nombre,\r\n"
						        		+ "    e.anno\r\n"
						        		+ "ORDER BY\r\n"
						        		+ "    c.nombre ASC,\r\n"
						        		+ "    e.anno ASC;");
       
        
        List<Carrera> carreras = query.getResultList();

        // Implement your custom logic to organize the years chronologically for each Carrera
        // For example, you can have a Map<Carrera, List<Year>> where the keys are Carrera objects, 
        // and the values are lists of years representing the chronological order.

        // Create a ReporteDTO object based on the sorted Carrera list and organized years
        return new ReporteDTO(carreras, yearsMap);
    }

}