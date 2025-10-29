package com.curso._07_aop;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Log
@Cronometro
public class GestorFacturasImpl implements GestorFacturas {

	@Override
	public void insertar(String factura){
		System.out.println("Insertando fra:"+factura);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public void borrar(String factura){
		System.out.println("Borrando fra:"+factura);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
}
