package repositorios;

import DTO.CarreraDTO;
import DTO.EstudianteDTO;
import DTO.ReporteDTO;
import clases.Carrera;
import clases.Estudiante;
import clases.EstudianteCarrera;
import interfaces.RepoEstudianteCarrera;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class RepoEstudianteCarreraMySQL implements RepoEstudianteCarrera {
    private EntityManager manager;

    public RepoEstudianteCarreraMySQL(EntityManager manager) {
        this.manager = manager;
    }


    @Override
    public void matricular(Estudiante estudiante, Carrera carrera, int anioInscripcion, int anioGraduacion, int antiguedad, int id) {
        Estudiante managedEstudiante = manager.find(Estudiante.class, estudiante.getDni());
        Carrera managedCarrera = manager.find(Carrera.class, carrera.getId());

        if (managedEstudiante != null && managedCarrera != null) {
            manager.getTransaction().begin();
            EstudianteCarrera estudianteCarrera = new EstudianteCarrera(id, estudiante, carrera, anioInscripcion, anioGraduacion, antiguedad);
            manager.persist(estudianteCarrera);
            manager.getTransaction().commit();
        }
    }


    public boolean delete(int id) {
        manager.getTransaction().begin();
        EstudianteCarrera estudiante = manager.find(EstudianteCarrera.class, id);
        if (estudiante != null) {
            manager.remove(estudiante);
            manager.getTransaction().commit();
            return true;
        } else {
            manager.getTransaction().rollback();
            return false;
        }
    }


    //REVISAR
    @Override
    public List<CarreraDTO> getCarrerasConInscriptos() {
        TypedQuery<Carrera> query = manager.createQuery("SELECT c FROM Carrera c JOIN c.estudiantes e GROUP BY c ORDER BY SIZE(e) DESC", Carrera.class);
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
        TypedQuery<ReporteDTO> query = manager.createQuery(
                "SELECT NEW DTO.ReporteDTO(c.nombre, " +
                        "ec.anioInscripcion, " +
                        "COUNT(COALESCE(ec.anioInscripcion, 0)), " +
                        "COUNT(COALESCE(ec.anioGraduacion, 0))) FROM EstudianteCarrera ec " +
                        "LEFT JOIN ec.carrera c " +
                        "GROUP BY c.nombre, ec.anioInscripcion " +
                        "ORDER BY c.nombre ASC, ec.anioInscripcion ASC", ReporteDTO.class);

        return query.getResultList();
    }

}