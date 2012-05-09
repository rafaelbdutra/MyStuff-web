package br.com.dutra.mystuff.component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

import com.google.code.morphia.Morphia;

@Component
public class MorphiaCreator implements ComponentFactory<Morphia> {

	private Morphia morphia;

	@PostConstruct
	public void create() {
		this.morphia = new Morphia();
	}

	public Morphia getInstance() {
		return morphia;
	}

	@PreDestroy
	public void destroy() {
		this.morphia = null;
	}
}
