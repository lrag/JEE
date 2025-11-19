package com.curso._05_produces;

import javax.annotation.PostConstruct;

//@ApplicationScoped
public class Logger {

	private String fichero;

	public Logger() {
		super();
	}
	
	@PostConstruct
	public void inicializar() {
		System.out.println("ABRIENDO EL FICHERO PARA ESCRITURA");
	}
	
	//No tiene constructor por defecto:
	//CDI no puede instanciar la bean por su cuenta!
	public Logger(String fichero) {
		super();
		System.out.println("CONSTRUCTOR DE LOGGER CON PARÁMETROS");
		this.fichero = fichero;
	}
	
	public synchronized void escribir(String texto) {
		System.out.println("Escribiendo "+texto+" en "+fichero);		
	}
	
}
