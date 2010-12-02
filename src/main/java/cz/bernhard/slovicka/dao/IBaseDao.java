package cz.bernhard.slovicka.dao;

import java.util.List;

public interface IBaseDao<T> {
	
	T save(T object);
	List<T> findAll();

}
