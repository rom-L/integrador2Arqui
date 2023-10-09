package clases;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "estudiante_carrera")
public class EstudianteCarrera {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estudiante_dni")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    @Column(name = "anio_inscripcion")
    private Date anioInscripcion;

    @Column(name = "anio_graduacion", nullable = true)
    private Date anioGraduacion;

    public EstudianteCarrera(Estudiante estudiante, Carrera carrera, Date anioInscripcion, Date anioGraduacion) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.anioInscripcion = anioInscripcion;
        this.anioGraduacion = anioGraduacion;
    }

    public EstudianteCarrera() {

    }

    public Long getId() {
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

    public Date getAnioInscripcion() {
        return anioInscripcion;
    }

    public void setAnioInscripcion(Date anioInscripcion) {
        this.anioInscripcion = anioInscripcion;
    }

    public Date getAnioGraduacion() {
        return anioGraduacion;
    }

    public void setAnioGraduacion(Date anioGraduacion) {
        this.anioGraduacion = anioGraduacion;
    }
}
