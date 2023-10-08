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
			CarreraDTO carreraDTO = new CarreraDTO(carrera.getNombre());
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
    public List<ReporteDTO> getReportes() {
    	String queryString = "SELECT c.nombre AS carrera_nombre, ec.anioInscripcion AS anio, " +
                "COUNT(CASE WHEN ec.anioInscripcion IS NOT NULL THEN 1 ELSE NULL END) AS totalInscritos, " +
                "COUNT(CASE WHEN ec.anioGraduacion IS NOT NULL THEN 1 ELSE NULL END) AS totalGraduados " +
                "FROM Carrera c " +
                "LEFT JOIN EstudianteCarrera ec ON c.id = ec.carrera.id " +
                "GROUP BY c.nombre, ec.anioInscripcion " +
                "ORDER BY c.nombre ASC, ec.anioInscripcion ASC";
    	
    	Query query = manager.createNamedQuery(queryString);
    	
    	List<ReporteDTO> reporteDTOList = new ArrayList<>();

        List<Object[]> results = query.getResultList();
        for (Object[] result : results) {
            String carreraNombre = (String) result[0];
            int anio = (int) result[1];
            int totalInscritos = (int) result[2];
            int totalGraduados = (int) result[3];

            CarreraDTO carreraDTO = new CarreraDTO(carreraNombre);
            ReporteDTO reporteDTO = new ReporteDTO(carreraDTO, totalInscritos, totalGraduados, anio);

            reporteDTOList.add(reporteDTO);
        }

        return reporteDTOList;
    	
    }

}