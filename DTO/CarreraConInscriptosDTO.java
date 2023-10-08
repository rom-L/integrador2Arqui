package integrador2Arqui.DTO;

public class CarreraConInscriptosDTO {
	private int id;
	private String nombre;
	private int cantInscriptosPorAnio;
	private int egresadosPorAnio;

	public CarreraConInscriptosDTO(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public CarreraConInscriptosDTO(int id, String nombre, int cantInscriptosPorAnio, int egresadosPorAnio) {
		this(id, nombre);
		this.cantInscriptosPorAnio = cantInscriptosPorAnio;
		this.egresadosPorAnio = egresadosPorAnio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantInscriptosPorAnio() {
		return cantInscriptosPorAnio;
	}

	public void setCantInscriptosPorAnio(int cantInscriptosPorAnio) {
		this.cantInscriptosPorAnio = cantInscriptosPorAnio;
	}

	public int getEgresadosPorAnio() {
		return egresadosPorAnio;
	}

	public void setEgresadosPorAnio(int egresadosPorAnio) {
		this.egresadosPorAnio = egresadosPorAnio;
	}

	@Override
	public String toString() {
		return this.id + " - " + this.nombre;
	}
}
