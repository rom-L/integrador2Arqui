package integrador2Arqui.repositorios;

import java.util.List;

import integrador2Arqui.clases.Carrera;
import integrador2Arqui.interfaces.RepoCarrera;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RepoCarreraMySQL implements RepoCarrera {
	private EntityManager manager;
	
	public RepoCarreraMySQL(EntityManager manager) {
		this.manager = manager;
	}

	
	@Override
    public void insert(Carrera carrera) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(carrera);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            Carrera carrera = manager.find(Carrera.class, id);
            if (carrera != null) {
                manager.remove(carrera);
                transaction.commit();
                return true;
            } else {
                transaction.rollback();
                return false;
            }
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Carrera carrera) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.merge(carrera);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Carrera get(int id) {
        try {
            return manager.find(Carrera.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Carrera> getAll() {
        try {
            return manager.createQuery("SELECT c FROM Carrera c", Carrera.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
}
