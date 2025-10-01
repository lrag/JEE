package com.curso._07_aop;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Log
@Cronometro
public class GestorFacturasImpl implements GestorFacturas {

	@Override
	public void insertar(String factura){
		System.out.println("Insertando fra:"+factura);
	}
	
	@Override
	public void borrar(String factura){
		System.out.println("Borrando fra:"+factura);
	}
	
}
