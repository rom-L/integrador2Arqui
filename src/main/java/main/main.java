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
import java.util.List;

public class main {

    public static void main(String[] args) throws SQLException {
        FabricaRepositoriosMySQL mySQLFactory = (FabricaRepositoriosMySQL) FabricaRepositorios.getFactory(1);

        RepoCarreraMySQL repoCarrera = (RepoCarreraMySQL) mySQLFactory.getRepoCarrera();
        RepoEstudianteMySQL repoEstudiante = (RepoEstudianteMySQL) mySQLFactory.getRepoEstudiante();
        RepoEstudianteCarreraMySQL repoEstudianteCarrera = (RepoEstudianteCarreraMySQL) mySQLFactory.getRepoEstudianteCarrera();

        ///2
        //a)
        Estudiante est1 = new Estudiante(557968524, "Carlos Manuel", "Serrín", 18, "Male", "Las Heras", "TE-557968524");
        Estudiante est2 = new Estudiante(557968525, "Juan", "Martel", 18, "Male", "Las Heras", "TE-557968525");
        repoEstudiante.insert(est1);
        repoEstudiante.insert(est2);
        //b)
        Carrera car1 = new Carrera("TUDAI");
        repoCarrera.insert(car1);
        repoEstudianteCarrera.matricular(est1, car1);
        repoEstudianteCarrera.matricular(est2, car1);
        //c)
        List<EstudianteDTO> ests = repoEstudiante.getAll();
        for (EstudianteDTO est : ests) {
            System.out.println(est);
        }
        //d)
        EstudianteDTO estt = repoEstudiante.getByLibreta(557968524);
        System.out.println(estt);
        //e)
        ests = repoEstudiante.getAllByGenero("Male");
        for (EstudianteDTO est : ests) {
            System.out.println(est);
        }
        //f)
        List<CarreraDTO> carrs = repoEstudianteCarrera.getCarrerasConInscriptos();
        for (CarreraDTO carr : carrs) {
            System.out.println(carr);
        }
        //g)
        ests = repoEstudianteCarrera.getEstudiantesByCarrera(car1, "Las Heras");
        for (EstudianteDTO est : ests) {
            System.out.println(estt);
        }

        //3)
        List<ReporteDTO> reportes = repoEstudianteCarrera.getReportes();
        for (ReporteDTO reporte : reportes) {
            System.out.println(reporte);
        }

    }
}