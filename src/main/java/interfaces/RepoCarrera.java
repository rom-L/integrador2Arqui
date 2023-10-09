package interfaces;

import clases.Carrera;

import java.util.List;

public interface RepoCarrera {
	public void insert(Carrera c);
	public boolean delete(int id);
	public boolean update(Carrera c);
	public Carrera get(int id);
	public List<Carrera> getAll();
}
