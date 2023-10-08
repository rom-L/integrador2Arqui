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
    private Set<Estudiante> estudiantes;

    protected Carrera() {
        //se usa un constructor sin argumentos para que JPA instancie la entidad
    }

    public Carrera(String nombre) {
        this();    //llamo al constructor sin argumentos para instanciar la entidad
        this.nombre = nombre;
        this.estudiantes = new HashSet<>();
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
