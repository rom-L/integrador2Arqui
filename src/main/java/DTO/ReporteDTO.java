package DTO;

public class ReporteDTO {
    private String carrera;
    private Long cantInscriptosPorAnio;
    private Long egresadosPorAnio;
    private Long anio;



	public ReporteDTO(String carrera, Long anio, Long cantInscriptosPorAnio, Long egresadosPorAnio) {
		super();
		this.carrera = carrera;
		this.cantInscriptosPorAnio = cantInscriptosPorAnio;
		this.egresadosPorAnio = egresadosPorAnio;
		this.anio = anio;
	}


	public String getCarrera() {
		return carrera;
	}


	public Long getCantInscriptosPorAnio() {
		return cantInscriptosPorAnio;
	}


	public Long getEgresadosPorAnio() {
		return egresadosPorAnio;
	}


	public Long getAnio() {
		return anio;
	}


	@Override
	public String toString() {
		return "ReporteDTO [carrera=" + carrera + ", cantInscriptosPorAnio=" + cantInscriptosPorAnio
				+ ", egresadosPorAnio=" + egresadosPorAnio + ", anio=" + anio + "]";
	}

    
}
