package fabrica;

import interfaces.RepoCarrera;
import interfaces.RepoEstudiante;
import interfaces.RepoMatriculacion;

import java.sql.SQLException;

public abstract class FabricaRepositorios {
	public static final int MYSQL_JPA = 1;
	
	public abstract RepoCarrera getRepoCarrera();
	
	public abstract RepoEstudiante getRepoEstudiante();
	
	public abstract RepoMatriculacion getRepoMatriculacion();
	
	public static FabricaRepositorios getFactory(int whichFactory) throws SQLException {
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
