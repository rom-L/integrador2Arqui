package clases;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carreras")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "carrera")
    private Set<Matriculacion> matriculaciones;

    public Carrera(String nombre) {
        this();
        this.nombre = nombre;
        this.matriculaciones = new HashSet<>();
    }

    protected Carrera() {

    }


    public Set<Matriculacion> getMatriculaciones() {
        return matriculaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addMatriculacion(Matriculacion matriculacion) {
        matriculaciones.add(matriculacion);
    }

    public void removeMatriculacion(Matriculacion matriculacion) {
        matriculaciones.remove(matriculacion);
    }

    public int getId() {
        return this.id;
    }
}
