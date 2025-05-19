package com.curso.modelo.persistencia;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory emf;
	
	public synchronized static EntityManagerFactory getEMF(){
		
		if(emf == null){
			emf = Persistence.createEntityManagerFactory("H2PU");
		}
		
		return emf;		
	}	
	
}

