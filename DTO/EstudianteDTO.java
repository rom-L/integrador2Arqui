package integrador2Arqui.DTO;


public class EstudianteDTO {
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String genero;
    private String ciudadResidencia;
    private String numeroLibreta;

    public EstudianteDTO(int dni, String nombre, String apellido, int edad, String genero, String ciudadResidencia, String numeroLibreta) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudadResidencia = ciudadResidencia;
        this.numeroLibreta = numeroLibreta;
    }


}
