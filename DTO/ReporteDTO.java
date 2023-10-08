package integrador2Arqui.DTO;

public class ReporteDTO {
    private CarreraDTO carrera;
    private int cantInscriptos;
    private int egresadosPorAno;

    public ReporteDTO(CarreraDTO carrera, int cantInscriptos, int egresadosPorAno) {
        this.carrera = carrera;
        this.cantInscriptos = cantInscriptos;
        this.egresadosPorAno = egresadosPorAno;
    }


    public CarreraDTO getCarrera() {
        return carrera;
    }

    public int getCantInscriptos() {
        return cantInscriptos;
    }

    public void setCantInscriptos(int cantInscriptos) {
        this.cantInscriptos = cantInscriptos;
    }

    public int getEgresadosPorAno() {
        return egresadosPorAno;
    }

    public void setEgresadosPorAno(int egresadosPorAno) {
        this.egresadosPorAno = egresadosPorAno;
    }

    @Override
    public String toString() {
        return this.carrera + "| Inscriptos: " + this.cantInscriptos + "| Egresados por año: " + this.egresadosPorAno;
    }
}
