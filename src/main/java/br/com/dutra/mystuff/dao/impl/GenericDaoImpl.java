package br.com.dutra.mystuff.dao.impl;

import java.util.List;

import br.com.dutra.mystuff.dao.GenericDao;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;

public abstract class GenericDaoImpl<T, KEY> extends BasicDAO<T, KEY> implements GenericDao<T, KEY> {

	protected GenericDaoImpl(Mongo mongo, Morphia morphia, String dbName) {
		super(mongo, morphia, dbName);
	}

	@Override
	public List<T> getAll() {
		return find().asList();
	}

	@Override
	public T getById(KEY id) {
		return get(id);
	}

	@Override
	public void renew(T entity) {
		
	}

	@Override
	public T persist(T entity) {
		save(entity);
		return entity;
	}

	@Override
	public void remove(T entity) {
		
	}

}
