package integrador2Arqui.fabrica;

import java.sql.SQLException;

import integrador2Arqui.interfaces.RepoCarrera;
import integrador2Arqui.interfaces.RepoEstudiante;
import integrador2Arqui.interfaces.RepoEstudianteCarrera;

public abstract class FabricaRepositorios {
	public static final int MYSQL_JPA = 1;
	
	public abstract RepoCarrera getRepoCarrera();
	
	public abstract RepoEstudiante getRepoEstudiante();
	
	public abstract RepoEstudianteCarrera getRepoEstudianteCarrera();
	
	public static FabricaRepositorios getInstance(int whichFactory) throws SQLException {
		switch (whichFactory) {
		case MYSQL_JPA:
			return FabricaRepositoriosMySQL.getInstance();
		// case DERBY_JDBC: return new DerbyJDBCDAOFactory();
		// case JPA_HIBERNATE: …
		default:
			return null;
		}
	}

	public void closeConnection() {
		// TODO Auto-generated method stub
		
	}
}
