package com.curso.modelo.persistencia;

public class FactoriaClienteDao {

	public static ClienteDao getClienteDao(){
		return new ClienteDaoJpaImplementation();
	}
	
	
}
