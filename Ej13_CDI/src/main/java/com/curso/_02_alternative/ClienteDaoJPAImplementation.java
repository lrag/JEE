package com.curso._02_alternative;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative //Por defecto
public class ClienteDaoJPAImplementation implements ClienteDao{

	@Override
	public void insertar(String aviso) {
		System.out.println("em.persist(cliente);");		
	}

}
