package clases;

import jakarta.persistence.*;

@Entity
@Table(name = "matriculaciones")
public class Matriculacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "estudiante_dni")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    @Column(name = "anio_inscripcion")
    private int anioInscripcion;

    @Column(name = "anio_graduacion", nullable = true)
    private Integer anioGraduacion;

    @Column(name = "antiguedad")
    private int antiguedad;

    public Matriculacion(Estudiante estudiante, Carrera carrera, int anioInscripcion, Integer anioGraduacion, int antiguedad) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.anioInscripcion = anioInscripcion;
        this.anioGraduacion = anioGraduacion;
        this.antiguedad = antiguedad;
    }

    public Matriculacion() {

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
