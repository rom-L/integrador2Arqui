package integrador2Arqui.clases;

import java.util.List;

public class Carrera {
	private int id;
	private String nombre;
	private List<Estudiante> estudiantes; 
	
	public Carrera(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void agregarEstudiante(Estudiante e) {
		estudiantes.add(e);
	}
	
	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}
	
	
	
	

}
