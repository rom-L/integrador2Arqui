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
    private int tiempoCursada;

    public EstudianteCarrera() {
        // Default constructor
    }

    public EstudianteCarrera(Estudiante estudiante, Carrera carrera, boolean graduado, int tiempoCursada) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.graduado = graduado;
        this.tiempoCursada = tiempoCursada;
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

    public int getTiempoCursada() {
        return tiempoCursada;
    }

    public void setTiempoCursada(int tiempoCursada) {
        this.tiempoCursada = tiempoCursada;
    }
}
