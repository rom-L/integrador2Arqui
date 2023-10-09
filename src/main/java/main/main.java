package main;

import DTO.CarreraDTO;
import DTO.EstudianteDTO;
import DTO.ReporteDTO;
import clases.Carrera;
import clases.Estudiante;
import fabrica.FabricaRepositorios;
import fabrica.FabricaRepositoriosMySQL;
import repositorios.RepoCarreraMySQL;
import repositorios.RepoEstudianteCarreraMySQL;
import repositorios.RepoEstudianteMySQL;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

public class main {

    public static void main(String[] args) throws SQLException {
        FabricaRepositoriosMySQL mySQLFactory = (FabricaRepositoriosMySQL) FabricaRepositorios.getFactory(1);

        RepoCarreraMySQL repoCarrera = (RepoCarreraMySQL) mySQLFactory.getRepoCarrera();
        RepoEstudianteMySQL repoEstudiante = (RepoEstudianteMySQL) mySQLFactory.getRepoEstudiante();
        RepoEstudianteCarreraMySQL repoEstudianteCarrera = (RepoEstudianteCarreraMySQL) mySQLFactory.getRepoEstudianteCarrera();

        ///2
        System.out.println("|2|");
        //a)
        System.out.println("a)");
        Estudiante est1 = new Estudiante(557968524, "Carlos Manuel", "Serrín", 18, "Male", "Las Heras", "TE-557968524");
        Estudiante est2 = new Estudiante(557968525, "Juan", "Martel", 18, "Male", "Las Heras", "TE-557968525");
        //repoEstudiante.insert(est1);
        //repoEstudiante.insert(est2);
        //b)
        System.out.println("b)");
        Carrera car1 = new Carrera("TUDAI");
        //repoCarrera.insert(car1);
        repoEstudianteCarrera.matricular(est1, car1, 2017, 0, 4, 1);
        repoEstudianteCarrera.matricular(est2, car1, 2018, 0, 3, 2);
        //c)
        System.out.println("c)");
        List<EstudianteDTO> ests = repoEstudiante.getAll();
        for (EstudianteDTO est : ests) {
            System.out.println(est);
        }
        //d)
        System.out.println("d)");
        EstudianteDTO estt = repoEstudiante.getByLibreta("TE-557968525");
        System.out.println(estt);
        //e)
        System.out.println("e)");
        ests = repoEstudiante.getAllByGenero("Male");
        for (EstudianteDTO est : ests) {
            System.out.println(est);
        }
        //f)
        System.out.println("f)");
        List<CarreraDTO> carrs = repoEstudianteCarrera.getCarrerasConInscriptos();
        for (CarreraDTO carr : carrs) {
            System.out.println(carr);
        }
        //g)
        System.out.println("g)");
        ests = repoEstudianteCarrera.getEstudiantesByCarrera(car1, "Las Heras");
        for (EstudianteDTO est : ests) {
            System.out.println(estt);
        }

        System.out.println();

        //3)
        System.out.println("|3|");
        List<ReporteDTO> reportes = repoEstudianteCarrera.getReportes();
        System.out.println("Number of reportes: " + reportes.size());

        for (ReporteDTO reporte : reportes) {
            System.out.println(reporte);
        }

    }
}