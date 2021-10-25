package uqam.mgl7361.projet.carteinfidelite.transversal.dao;



import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

public interface GenericDao<T, PK extends Serializable> {

	public EntityManager getEntityManager();

	List<T> getAll();

	List<T> getAllDistinct();

	T get(PK id);

	boolean exists(PK id);

	T save(T object);

	void remove(T object);

	void remove(PK id);

	void flush();
}
