package com.curso._07_aop;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Log
@Cronometro
public class GestorClientesImpl implements GestorClientes {

	@Override
	public void insertar(String cliente){
		System.out.println("Insertando cli:"+cliente);
	}
	
	@Override
	public void borrar(String cliente){
		System.out.println("Borrando cli:"+cliente);
	}
	
}
