package fabrica;

import interfaces.RepoCarrera;
import interfaces.RepoEstudiante;
import interfaces.RepoEstudianteCarrera;
import repositorios.RepoCarreraMySQL;
import repositorios.RepoEstudianteCarreraMySQL;
import repositorios.RepoEstudianteMySQL;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaRepositoriosMySQL extends FabricaRepositorios {
    private static FabricaRepositoriosMySQL INSTANCE;
    private EntityManagerFactory entityManagerFactory;

    private FabricaRepositoriosMySQL() {
        entityManagerFactory = Persistence.createEntityManagerFactory("integrador2");
    }

    public static FabricaRepositoriosMySQL getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FabricaRepositoriosMySQL();
        }
        return INSTANCE;
    }

    @Override
    public void closeConnection() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }

    @Override
    public RepoCarrera getRepoCarrera() {
        return new RepoCarreraMySQL(entityManagerFactory.createEntityManager());
    }

    @Override
    public RepoEstudianteCarrera getRepoEstudianteCarrera() {
        return new RepoEstudianteCarreraMySQL(entityManagerFactory.createEntityManager());
    }

    @Override
    public RepoEstudiante getRepoEstudiante() {
        return new RepoEstudianteMySQL(entityManagerFactory.createEntityManager());
    }
}
