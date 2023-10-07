package integrador2Arqui.repositorios;

import integrador2Arqui.clases.Carrera;
import integrador2Arqui.interfaces.RepoCarrera;
import jakarta.persistence.EntityManager;

public class RepoCarreraMySQL implements RepoCarrera {
	private EntityManager manager;
	
	public RepoCarreraMySQL(EntityManager manager) {
		this.manager = manager;
	}

	
	@Override
	public void insert(Carrera c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Carrera c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Carrera get(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
