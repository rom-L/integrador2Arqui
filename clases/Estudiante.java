package integrador2Arqui.clases;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "edad")
    private int edad;

    @Column(name = "genero")
    private String genero;

    @Column(name = "dni")
    private String dni;

    @Column(name = "ciudad_residencia")
    private String ciudadResidencia;

    @Column(name = "numero_libreta")
    private String numeroLibreta;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "estudiante_carrera",
            joinColumns = @JoinColumn(name = "estudiante_id"),
            inverseJoinColumns = @JoinColumn(name = "carrera_id")
    )
    private Set<Carrera> carreras = new HashSet<>();

}