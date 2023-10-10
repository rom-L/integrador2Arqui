package repositorios;

import DTO.CarreraDTO;
import DTO.EstudianteDTO;
import DTO.ReporteDTO;
import clases.Carrera;
import clases.Estudiante;
import clases.Matriculacion;
import interfaces.RepoMatriculacion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class RepoMatriculacionMySQL implements RepoMatriculacion {
    private EntityManager manager;

    public RepoMatriculacionMySQL(EntityManager manager) {
        this.manager = manager;
    }


    @Override
    public void matricular(Estudiante estudiante, Carrera carrera, int anioInscripcion, Integer anioGraduacion, int antiguedad) {
        manager.getTransaction().begin();


        // if both are persisted somewhere

            System.out.println("existen");
            Matriculacion matriculacion = new Matriculacion(estudiante, carrera, anioInscripcion, anioGraduacion, antiguedad);
            manager.persist(matriculacion);

        manager.getTransaction().commit();
    }


    public boolean delete(int id) {
        manager.getTransaction().begin();
        Matriculacion estudiante = manager.find(Matriculacion.class, id);
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
    public List<CarreraDTO> getCarrerasConInscriptosDescendentemente() {
        TypedQuery<Carrera> query = manager.createQuery(
                "SELECT c FROM Carrera c JOIN c.matriculaciones m GROUP BY c.id, c.nombre ORDER BY COUNT(m) DESC",
                Carrera.class
        );
        List<Carrera> carreras = query.getResultList();
        List<CarreraDTO> carrerasDTO = new ArrayList<CarreraDTO>();
        for (Carrera carrera : carreras) {
            CarreraDTO carreraDTO = new CarreraDTO(carrera.getNombre());
            carrerasDTO.add(carreraDTO);
        }
        return carrerasDTO;
    }

    @Override
    public List<EstudianteDTO> getEstudiantesByCarreraAndCiudadResidencia(Carrera carrera, String ciudadResidencia) {
        TypedQuery<Estudiante> query = manager.createQuery(
                "SELECT e FROM Estudiante e " +
                        "WHERE e.ciudadResidencia = :ciudad " +
                        "AND e IN (SELECT m.estudiante FROM Matriculacion m WHERE m.carrera = :carrera)",
                Estudiante.class
        );
        query.setParameter("ciudad", ciudadResidencia); // Set the ciudad parameter
        query.setParameter("carrera", carrera); // Set the carrera parameter
        List<Estudiante> estudiantes = query.getResultList();
        List<EstudianteDTO> estudiantesDTO = new ArrayList<>();
        for (Estudiante estudiante : estudiantes) {
            EstudianteDTO estudianteDTO = new EstudianteDTO(estudiante.getDni(), estudiante.getNombres(),
                    estudiante.getApellido(), estudiante.getEdad(),
                    estudiante.getGenero(), estudiante.getCiudadResidencia(),
                    estudiante.getNumeroLibreta());
            estudiantesDTO.add(estudianteDTO);
        }
        return estudiantesDTO;
    }

    @Override
    public List<ReporteDTO> getReportes() {
        TypedQuery<ReporteDTO> query = manager.createQuery(
                "SELECT NEW DTO.ReporteDTO(c.nombre, " +
                        "ec.anioInscripcion, " +
                        "COUNT(COALESCE(ec.anioInscripcion, 0)), " +
                        "COUNT(COALESCE(ec.anioGraduacion, 0))) FROM Matriculacion ec " +
                        "LEFT JOIN ec.carrera c " +
                        "GROUP BY c.nombre, ec.anioInscripcion " +
                        "ORDER BY c.nombre ASC, ec.anioInscripcion ASC", ReporteDTO.class);

        return query.getResultList();
    }

}