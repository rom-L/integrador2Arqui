package integrador2Arqui.clases;

import java.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carrera")
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carrera_id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(mappedBy = "carreras")
    private Set<Estudiante> estudiantes = new HashSet<>();

    public Carrera() {
        // Default constructor
    }
    
    public Carrera(String nombre) {
        this.nombre = nombre;
    }

    public Set<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Set<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void addEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
        estudiante.getCarreras().add(this);
    }

    public void removeEstudiante(Estudiante estudiante) {
        estudiantes.remove(estudiante);
        estudiante.getCarreras().remove(this);
    }
}
