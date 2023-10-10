package repositorios;

import DTO.CarreraConInscriptosYEgresadosDTO;
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
        Matriculacion matriculacion = new Matriculacion(estudiante, carrera, anioInscripcion, anioGraduacion, antiguedad);

        Matriculacion existingMatriculacion = manager.find(Matriculacion.class, matriculacion.getId());

        if (existingMatriculacion == null) {
            manager.getTransaction().begin();
            manager.persist(matriculacion);
            manager.getTransaction().commit();
        }
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
    public List<CarreraConInscriptosYEgresadosDTO> getCarrerasConInscriptosDescendentemente() {
        TypedQuery<Carrera> query = manager.createQuery(
                "SELECT c FROM Carrera c JOIN c.matriculaciones m GROUP BY c.id, c.nombre ORDER BY COUNT(m) DESC",
                Carrera.class
        );
        List<Carrera> carreras = query.getResultList();
        List<CarreraConInscriptosYEgresadosDTO> carrerasDTO = new ArrayList<>();
        for (Carrera carrera : carreras) {
            CarreraConInscriptosYEgresadosDTO carreraDTO = new CarreraConInscriptosYEgresadosDTO(carrera.getNombre());
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
    public ReporteDTO getReporte() {
        ReporteDTO reporteDTO = new ReporteDTO();

        /////////Obtenemos todas las carrerasDTO
        TypedQuery<CarreraConInscriptosYEgresadosDTO> allCarreras = manager.createQuery(
                "SELECT NEW DTO.CarreraConInscriptosYEgresadosDTO(c.nombre) FROM Carrera c ORDER BY c.nombre ASC",
                CarreraConInscriptosYEgresadosDTO.class
        );

        List<CarreraConInscriptosYEgresadosDTO> carreraConInscriptosYEgresadosDTOS = allCarreras.getResultList();
        /////////Obtenemos todas las carrerasDTO

        /////////Obtenemos todos los años registrados dónde hubo aunque sea una inscripción y graduacion
        TypedQuery<Integer> distinctInscripcionYearsQuery = manager.createQuery(
                "SELECT DISTINCT m.anioInscripcion FROM Matriculacion m ORDER BY m.anioInscripcion ASC", Integer.class
        );

        List<Integer> inscripcionYears = distinctInscripcionYearsQuery.getResultList();

        TypedQuery<Integer> distinctGraduacionYearsQuery = manager.createQuery(
                "SELECT DISTINCT m.anioInscripcion FROM Matriculacion m ORDER BY m.anioGraduacion ASC", Integer.class
        );

        List<Integer> graduacionYears = distinctGraduacionYearsQuery.getResultList();
        /////////Obtenemos todos los años registrados dónde hubo aunque sea una inscripción y graduacion

        //por cada carrera
        for (CarreraConInscriptosYEgresadosDTO c : carreraConInscriptosYEgresadosDTOS) {
            for (Integer inscripcionYear : inscripcionYears) {
                //agregar todos los estudiantes que se inscribieron en x carrera en x año
                TypedQuery<EstudianteDTO> query = manager.createQuery(
                        "SELECT NEW DTO.EstudianteDTO(e.dni, e.nombres, e.apellido, e.edad, e.genero, e.ciudadResidencia, e.numeroLibreta) " +
                                "FROM Matriculacion m " +
                                "JOIN m.estudiante e " +
                                "WHERE m.carrera.nombre = :carreraNombre " +
                                "AND m.anioInscripcion = :year",
                        EstudianteDTO.class
                );

                query.setParameter("carreraNombre", c.getNombre());
                query.setParameter("year", inscripcionYear);

                c.agregarInscriptosEnAnio(query.getResultList(), inscripcionYear);
            }

            for (Integer graduacionYear : graduacionYears) {
                //agregar todos los estudiantes que se inscribieron en x carrera en x año
                TypedQuery<EstudianteDTO> query = manager.createQuery(
                        "SELECT NEW DTO.EstudianteDTO(e.dni, e.nombres, e.apellido, e.edad, e.genero, e.ciudadResidencia, e.numeroLibreta) " +
                                "FROM Matriculacion m " +
                                "JOIN m.estudiante e " +
                                "WHERE m.carrera.nombre = :carreraNombre " +
                                "AND m.anioGraduacion = :year",
                        EstudianteDTO.class
                );

                query.setParameter("carreraNombre", c.getNombre());
                query.setParameter("year", graduacionYear);

                c.agregarGraduadosEnAnio(query.getResultList(), graduacionYear);
            }

            reporteDTO.agregarCarrerasConInscriptosEnAnio(c);
        }

        return reporteDTO;
    }

}