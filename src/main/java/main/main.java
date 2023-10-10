package main;

import DTO.CarreraDTO;
import DTO.EstudianteDTO;
import DTO.ReporteDTO;
import clases.Carrera;
import clases.Estudiante;
import fabrica.FabricaRepositorios;
import fabrica.FabricaRepositoriosMySQL;
import repositorios.RepoCarreraMySQL;
import repositorios.RepoMatriculacionMySQL;
import repositorios.RepoEstudianteMySQL;

import java.sql.SQLException;
import java.util.List;

public class main {

    public static void main(String[] args) throws SQLException {
        FabricaRepositoriosMySQL mySQLFactory = (FabricaRepositoriosMySQL) FabricaRepositorios.getFactory(1);

        RepoCarreraMySQL repoCarrera = (RepoCarreraMySQL) mySQLFactory.getRepoCarrera();
        RepoEstudianteMySQL repoEstudiante = (RepoEstudianteMySQL) mySQLFactory.getRepoEstudiante();
        RepoMatriculacionMySQL repoMatriculacion = (RepoMatriculacionMySQL) mySQLFactory.getRepoMatriculacion();

        ///2
        System.out.println("|2|");
        //a)
        System.out.println("a)");
        Estudiante est1 = new Estudiante(557968524, "Carlos Manuel", "Serrín", 18, "Male", "Las Heras", "TE-557968524");
        Estudiante est2 = new Estudiante(557968525, "Juan", "Martel", 24, "Male", "Las Heras", "TE-557968525");
        Estudiante est3 = new Estudiante(44685976, "Franco", "Scheneiderr", 90, "null", "montorneros", "TE-44685976");
        Estudiante est4 = new Estudiante(55796888, "Josefina Ocho", "Martel", 18, "Female", "Vaticano", "TE-55796888");
        repoEstudiante.insert(est1);
        repoEstudiante.insert(est2);
        repoEstudiante.insert(est3);
        repoEstudiante.insert(est4);
        //b)
        System.out.println("b)");
        Carrera car1 = new Carrera("TUDAI");
        Carrera car2 = new Carrera("TUARI");
        repoCarrera.insert(car1);
        repoCarrera.insert(car2);
        repoMatriculacion.matricular(est1, car1, 2017, null, 4);
        repoMatriculacion.matricular(est2, car1, 2018, null, 3);
        repoMatriculacion.matricular(est1, car2, 2018, null, 3);
        repoMatriculacion.matricular(est2, car2, 2019, null, 2);
        repoMatriculacion.matricular(est3, car2, 2020, null, 1);
        repoMatriculacion.matricular(est4, car2, 2016, null, 5);
        //c)
        System.out.println("c)");
        List<EstudianteDTO> ests = repoEstudiante.getAll();
        for (EstudianteDTO est : ests) {
            System.out.println(est);
        }
        //d)
        System.out.println("d)");
        EstudianteDTO est = repoEstudiante.getByLibreta("TE-557968525");
        System.out.println(est);
        //e)
        System.out.println("e)");
        ests = repoEstudiante.getAllByGenero("Male");
        for (EstudianteDTO e : ests) {
            System.out.println(e);
        }
        //f)
        System.out.println("f)");
        List<CarreraDTO> carrs = repoMatriculacion.getCarrerasConInscriptosDescendentemente();
        for (CarreraDTO carr : carrs) {
            System.out.println(carr);
        }
        //g)
        System.out.println("g)");
        ests = repoMatriculacion.getEstudiantesByCarreraAndCiudadResidencia(car1, "Las Heras");
        for (EstudianteDTO e : ests) {
            System.out.println(e);
        }

        System.out.println();

        //3)
        System.out.println("|3|");
        List<ReporteDTO> reportes = repoMatriculacion.getReportes();
        System.out.println("Number of reportes: " + reportes.size());

        for (ReporteDTO reporte : reportes) {
            System.out.println(reporte);
        }

    }
}