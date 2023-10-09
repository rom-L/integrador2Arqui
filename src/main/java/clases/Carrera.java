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

    @ManyToMany(mappedBy = "carreras")
    private Set<Estudiante> estudiantes;
    
    public Carrera(String nombre) {
        this();
        this.nombre = nombre;
        this.estudiantes = new HashSet<>();
    }

    protected Carrera() {

    }


    public Set<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    public void addEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void removeEstudiante(Estudiante estudiante) {
        estudiantes.remove(estudiante);
    }

	public int getId() {
		return this.id;
	}
}
