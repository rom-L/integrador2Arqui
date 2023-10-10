package clases;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "estudiantes")
public class Estudiante {
	
	@Id
	@Column(name = "dni")
	private int dni;

	@Column(name = "nombres")
	private String nombres;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "edad")
	private int edad;

	@Column(name = "genero")
	private String genero;

	@Column(name = "ciudad_residencia")
	private String ciudadResidencia;

	@Column(name = "numero_libreta")
	private String numeroLibreta;

	@OneToMany(mappedBy = "estudiante")
	private Set<Matriculacion> matriculaciones;

	protected Estudiante() {
		//se usa un constructor sin argumentos para que JPA instancie la entidad
	}

	public Estudiante(int dni, String nombres, String apellido, int edad, String genero, String ciudadResidencia, String numeroLibreta) {
		this();		//llamo al constructor sin argumentos para instanciar la entidad
		this.dni = dni;
		this.nombres = nombres;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.ciudadResidencia = ciudadResidencia;
		this.numeroLibreta = numeroLibreta;
		this.matriculaciones = new HashSet<>();
	}

	public int getDni() {
		return dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCiudadResidencia() {
		return ciudadResidencia;
	}

	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}

	public String getNumeroLibreta() {
		return numeroLibreta;
	}

	public void setNumeroLibreta(String numeroLibreta) {
		this.numeroLibreta = numeroLibreta;
	}

	public Set<Matriculacion> getMatriculaciones() {
		return matriculaciones;
	}

	public void addMatriculacion(Matriculacion matriculacion) {
		this.matriculaciones.add(matriculacion);
	}

	public void removeMatriculacion(Matriculacion matriculacion) {
		this.matriculaciones.remove(matriculacion);
	}
}