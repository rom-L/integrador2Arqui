package integrador2Arqui;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import integrador2Arqui.DTO.CarreraDTO;
import integrador2Arqui.DTO.EstudianteDTO;
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
		//System.out.println(est);
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
		
	}
	public static List<Estudiante> obtenerEstudiantes() throws FileNotFoundException, IOException {
		List<Estudiante> lista = new ArrayList<>();
		CSVParser parser = CSVFormat.DEFAULT.withHeader()
				.parse(new FileReader("src/integrador2Arqui/CSV/estudiantes.csv"));
		for (CSVRecord row : parser) {
			Estudiante estudiante = new Estudiante(Integer.parseInt(row.get("DNI")), row.get("nombre"), row.get("apellidos"), Integer.parseInt(row.get("edad")), row.get("genero"), row.get("ciudad"), row.get("LU"));
			lista.add(estudiante);
		}
		return lista;	
	}
	
	public static List<Carrera> obtenerCarreras() throws FileNotFoundException, IOException {
		List<Carrera> lista = new ArrayList<>();
		CSVParser parser = CSVFormat.DEFAULT.withHeader()
				.parse(new FileReader("src/integrador2Arqui/CSV/carreras.csv"));
		for (CSVRecord row : parser) {
			Carrera carrera = new Carrera(Integer.parseInt(row.get("id_carrera")), row.get("carrera"));
			lista.add(carrera);
		}
		return lista;
	}
	
	public static List<EstudianteCarrera> obtenerEstudiantesCarreras() throws FileNotFoundException, IOException {
		List<EstudianteCarrera> lista = new ArrayList<>();
		CSVParser parser = CSVFormat.DEFAULT.withHeader()
				.parse(new FileReader("src/integrador2Arqui/CSV/estudianteCarrera.csv"));
		for (CSVRecord row : parser) {
			EstudianteCarrera carrera = new EstudianteCarrera(Integer.parseInt(row.get("id_estudiante")), Integer.parseInt(row.get("id_carrera")), Boolean.parseBoolean(row.get("graduado")), row.get("antiguedad"));
			lista.add(carrera);
		}
		return lista;
	}
}
