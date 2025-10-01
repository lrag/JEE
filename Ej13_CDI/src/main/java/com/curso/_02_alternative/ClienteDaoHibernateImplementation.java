package com.curso._02_alternative;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
public class ClienteDaoHibernateImplementation implements ClienteDao{

	@Override
	public void insertar(String cliente) {
		System.out.println("s.save(cliente)");		
	}

}
