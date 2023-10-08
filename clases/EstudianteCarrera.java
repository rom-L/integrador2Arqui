package integrador2Arqui.clases;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiante_carrera")
public class EstudianteCarrera {
	
    @Id
    @ManyToOne
    @JoinColumn(name = "estudiante_dni")
    private Estudiante estudiante;

    @Id
    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    @Column(name = "anio_inscripcion")
    private Date anioInscripcion;

    @Column(name = "anio_graduacion", nullable = true)
    private Date anioGraduacion;

    protected EstudianteCarrera() {
        //se usa un constructor sin argumentos para que JPA instancie la entidad
    }

    public EstudianteCarrera(Estudiante estudiante, Carrera carrera, Date anioInscripcion, Date anioGraduacion) {
        this();    //llamo al constructor sin argumentos para instanciar la entidad
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.anioInscripcion = anioInscripcion;
        this.anioGraduacion = anioGraduacion;
    }

    // Getters and setters
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

    public boolean isGraduado() {
        return graduado;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }

    public int getAniosAntiguedad() {
        return aniosAntiguedad;
    }

    public void setAniosAntiguedad(int aniosAntiguedad) {
        this.aniosAntiguedad = aniosAntiguedad;
    }
}
