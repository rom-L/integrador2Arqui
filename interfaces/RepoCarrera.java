package integrador2Arqui.interfaces; 

import java.util.List;
import integrador2Arqui.clases.Carrera;

public interface RepoCarrera{
	
		 public void insert(Carrera c);
		 public boolean delete(int id);
		 public boolean update(Carrera c);
		 public Carrera get(int id);
		 

}
