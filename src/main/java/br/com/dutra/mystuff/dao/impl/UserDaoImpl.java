package br.com.dutra.mystuff.dao.impl;

import br.com.caelum.vraptor.ioc.Component;
import br.com.dutra.mystuff.dao.UserDao;
import br.com.dutra.mystuff.domain.User;
import br.com.dutra.mystuff.utils.Constants;

import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

@Component
public class UserDaoImpl extends GenericDaoImpl<User, String> implements UserDao {

	protected UserDaoImpl(Mongo mongo, Morphia morphia) {
		super(mongo, morphia, Constants.DB_NAME);
	}

}
