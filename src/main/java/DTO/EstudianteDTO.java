package DTO;


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


    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public String getNumeroLibreta() {
        return numeroLibreta;
    }

    @Override
    public String toString() {
        return this.dni + " - " + this.nombre + " " + this.apellido + "| Edad: " + this.edad + "| Genero: " + this.genero + "| Ciudad: " + this.ciudadResidencia + "| Nro Libreta: " + this.numeroLibreta;
    }
}
