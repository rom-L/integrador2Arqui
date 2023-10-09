package DTO;

public class ReporteDTO {
    private CarreraDTO carrera;
    private int cantInscriptosPorAnio;
    private int egresadosPorAnio;
    private int anio;
    
    
    
	public ReporteDTO(CarreraDTO carrera, int cantInscriptosPorAnio, int egresadosPorAnio, int anio) {
		super();
		this.carrera = carrera;
		this.cantInscriptosPorAnio = cantInscriptosPorAnio;
		this.egresadosPorAnio = egresadosPorAnio;
		this.anio = anio;
	}


	public CarreraDTO getCarrera() {
		return carrera;
	}


	public int getCantInscriptosPorAnio() {
		return cantInscriptosPorAnio;
	}


	public int getEgresadosPorAnio() {
		return egresadosPorAnio;
	}


	public int getAnio() {
		return anio;
	}


	@Override
	public String toString() {
		return "ReporteDTO [carrera=" + carrera + ", cantInscriptosPorAnio=" + cantInscriptosPorAnio
				+ ", egresadosPorAnio=" + egresadosPorAnio + ", anio=" + anio + "]";
	}

    
}
