package br.com.dutra.mystuff.dao;

import org.bson.types.ObjectId;

import br.com.dutra.mystuff.domain.Stuff;

public interface StuffDao extends GenericDao<Stuff, ObjectId> {

}
