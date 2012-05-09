package br.com.dutra.mystuff.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.dutra.mystuff.dao.UserDao;
import br.com.dutra.mystuff.domain.Stuff;
import br.com.dutra.mystuff.domain.User;

@Resource
public class StuffController {

	private Result result;
	private UserDao userDao;

	public StuffController(Result result, UserDao userDao) {
		this.result = result;
		this.userDao = userDao;
	}

	@Get
	@Path("/stuff")
	public void itWorks() {
		boolean error = false;
		
		User user = null;
		try {
			user = userDao.getById("rafaelbdutra@gmail.com");
			if (user == null) {
				user = new User();
				user.setEmail("rafaelbdutra@gmail.com");
				user.setPassword("lalala");
				user.setFirstName("Rafael");
				user.setLastName("Dutra");
				
				Stuff s1 = new Stuff();
				s1.setName("Guitar");
				s1.setSize(Stuff.StuffSize.LARGE);
				s1.setQuantity(1);
				s1.setActive(Boolean.TRUE);
				s1.setBorrowed(Boolean.FALSE);
				
				Stuff s2 = new Stuff();
				s2.setName("Java Book");
				s2.setSize(Stuff.StuffSize.MEDIUM);
				s2.setQuantity(2);
				s2.setActive(Boolean.TRUE);
				s2.setBorrowed(Boolean.TRUE);
				
				List<Stuff> stuffs = new ArrayList<Stuff>();
				stuffs.add(s1);
				stuffs.add(s2);
				
				user.setStuffs(stuffs);
				
				userDao.persist(user);
			}
		} catch(Exception e) {
			error = true;
		}
		
		
		this.result.include("message", "Erro? " + error + "   First Name: " + (user == null ? "=/" : user.getFirstName()));
		this.result.forwardTo("/WEB-INF/jsp/stuff/working.jsp");
	}
}
