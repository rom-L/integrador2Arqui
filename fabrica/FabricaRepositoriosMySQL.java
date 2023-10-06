package integrador2Arqui.fabrica;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import integrador2Arqui.interfaces.RepoCarrera;
import integrador2Arqui.interfaces.RepoEstudiante;
import integrador2Arqui.interfaces.RepoEstudianteCarrera;

public class FabricaRepositoriosMySQL extends FabricaRepositorios {
    private static FabricaRepositoriosMySQL INSTANCE;
    private EntityManagerFactory entityManagerFactory;

    private FabricaRepositoriosMySQL() {
        entityManagerFactory = Persistence.createEntityManagerFactory("integrador2ArquiPU");
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
