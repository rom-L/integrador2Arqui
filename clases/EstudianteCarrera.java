package integrador2Arqui.clases;

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

    @Column(name = "graduado")
    private boolean graduado;

    @Column(name = "tiempo_cursada")
    private int aniosAntiguedad;

    public EstudianteCarrera(Estudiante estudiante, Carrera carrera, boolean graduado, int aniosAntiguedad) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.graduado = graduado;
        this.aniosAntiguedad = aniosAntiguedad;
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
