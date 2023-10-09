package integrador2Arqui;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import integrador2Arqui.DTO.CarreraDTO;
import integrador2Arqui.DTO.EstudianteDTO;
import integrador2Arqui.DTO.ReporteDTO;
import integrador2Arqui.clases.Carrera;
import integrador2Arqui.clases.Estudiante;
import integrador2Arqui.clases.EstudianteCarrera;
import integrador2Arqui.fabrica.FabricaRepositorios;
import integrador2Arqui.fabrica.FabricaRepositoriosMySQL;
import integrador2Arqui.repositorios.RepoCarreraMySQL;
import integrador2Arqui.repositorios.RepoEstudianteCarreraMySQL;
import integrador2Arqui.repositorios.RepoEstudianteMySQL;

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
