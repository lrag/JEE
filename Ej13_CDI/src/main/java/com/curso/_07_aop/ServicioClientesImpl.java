package com.curso._07_aop;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Log
@Cronometro
public class ServicioClientesImpl implements ServicioClientes {

	@Override
	public void insertar(String cliente){
		System.out.println("Insertando cli:"+cliente);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void borrar(String cliente){
		System.out.println("Borrando cli:"+cliente);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
}
