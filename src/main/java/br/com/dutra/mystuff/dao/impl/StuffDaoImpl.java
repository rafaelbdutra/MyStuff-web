package br.com.dutra.mystuff.dao.impl;

import org.bson.types.ObjectId;

import br.com.caelum.vraptor.ioc.Component;
import br.com.dutra.mystuff.dao.StuffDao;
import br.com.dutra.mystuff.domain.Stuff;
import br.com.dutra.mystuff.utils.Constants;

import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

@Component
public class StuffDaoImpl extends GenericDaoImpl<Stuff, ObjectId> implements StuffDao {

	protected StuffDaoImpl(Mongo mongo, Morphia morphia) {
		super(mongo, morphia, Constants.DB_NAME);
	}

}
