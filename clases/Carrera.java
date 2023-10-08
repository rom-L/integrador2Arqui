package integrador2Arqui.clases;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carreras")
public class Carrera {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(mappedBy = "carreras")
    private Set<Estudiante> estudiantes = new HashSet<>();

    public Carrera(Long id, String nombre) {
    		this.id = id;
    		this.nombre = nombre;	
    }
    
    public Carrera(String nombre) {
        this.nombre = nombre;
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

	public long getId() {
		return this.id;
	}
}
