package br.com.dutra.mystuff.dao;

import java.util.List;

public interface GenericDao<T, KEY> {
	public List<T> getAll();

	public T getById(KEY id);

	public void renew(T entity);

	public T persist(T entity);

	public void remove(T entity);
}
