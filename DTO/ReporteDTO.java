package integrador2Arqui.DTO;

public class ReporteDTO {
    private CarreraDTO carrera;
    private int cantInscriptosPorAnio;
    private int egresadosPorAnio;

    public ReporteDTO(CarreraDTO carrera, int cantInscriptosPorAnio, int egresadosPorAnio) {
        this.carrera = carrera;
        this.cantInscriptosPorAnio = cantInscriptosPorAnio;
        this.egresadosPorAnio = egresadosPorAnio;
    }


    public CarreraDTO getCarrera() {
        return carrera;
    }

    public int getCantInscriptos() {
        return cantInscriptosPorAnio;
    }

    public void setCantInscriptos(int cantInscriptosPorAnio) {
        this.cantInscriptosPorAnio = cantInscriptosPorAnio;
    }

    public int getEgresadosPorAno() {
        return egresadosPorAnio;
    }

    public void setEgresadosPorAno(int egresadosPorAno) {
        this.egresadosPorAnio = egresadosPorAno;
    }

    @Override
    public String toString() {
        return this.carrera + "| Inscriptos: " + this.cantInscriptosPorAnio + "| Egresados por año: " + this.egresadosPorAnio;
    }
}
