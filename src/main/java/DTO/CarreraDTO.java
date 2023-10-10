package DTO;

public class CarreraDTO {
    private String nombre;

    public CarreraDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
