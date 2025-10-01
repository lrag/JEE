package com.curso._05_produces;

//@ApplicationScoped
public class Logger {

	private String fichero;

	public Logger() {
		super();
	}
	
	//No tiene constructor por defecto:
	//CDI no puede instanciar la bean por su cuenta!
	public Logger(String fichero) {
		super();
		this.fichero = fichero;
	}
	
	public synchronized void escribir(String texto) {
		System.out.println("Escribiendo "+texto+" en "+fichero);		
	}
	
}
