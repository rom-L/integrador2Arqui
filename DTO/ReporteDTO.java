package integrador2Arqui.DTO;

public class ReporteDTO {
    private Long idCarrera;
    private String nombreCarrera;
    private int cantInscriptos;
    private int egresadosPorAno;

    public ReporteDTO(Long idCarrera, String nombreCarrera, int cantInscriptos, int egresadosPorAno) {
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
        this.cantInscriptos = cantInscriptos;
        this.egresadosPorAno = egresadosPorAno;
    }

    
    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
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
        return this.idCarrera + " - " + this.nombreCarrera + "| Inscriptos: " + this.cantInscriptos + "| Egresados por año: " + this.egresadosPorAno;
    }
}
