package clases;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiantes_carreras")
public class EstudianteCarrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "estudiantes_dni")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "carreras_id")
    private Carrera carrera;

    @Column(name = "anio_inscripcion")
    private int anioInscripcion;

    @Column(name = "anio_graduacion", nullable = true)
    private int anioGraduacion;

    @Column(name = "antiguedad")
    private int antiguedad;

    public EstudianteCarrera(int id,Estudiante estudiante, Carrera carrera, int anioInscripcion, int anioGraduacion, int antiguedad) {
        this.estudiante = estudiante;
        this.id = id;
        this.carrera = carrera;
        this.anioInscripcion = anioInscripcion;
        this.anioGraduacion = anioGraduacion;
        this.antiguedad = antiguedad;
    }

    public EstudianteCarrera() {

    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getId() {
        return id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public int getAnioInscripcion() {
        return anioInscripcion;
    }

    public void setAnioInscripcion(int anioInscripcion) {
        this.anioInscripcion = anioInscripcion;
    }

    public int getAnioGraduacion() {
        return anioGraduacion;
    }

    public void setAnioGraduacion(int anioGraduacion) {
        this.anioGraduacion = anioGraduacion;
    }
}
