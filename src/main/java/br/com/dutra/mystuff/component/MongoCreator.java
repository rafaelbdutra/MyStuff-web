package br.com.dutra.mystuff.component;

import java.net.UnknownHostException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoException;

@Component
public class MongoCreator implements ComponentFactory<Mongo> {

	private Mongo mongo;

	@PostConstruct
	public void create() {
		try {
			this.mongo = new Mongo();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}
	}

	public Mongo getInstance() {
		return mongo;
	}

	@PreDestroy
	public void destroy() {
		this.mongo = null;
	}
}
