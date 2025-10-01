package com.curso._05_produces;

public class FormateadorPDF implements Formateador{

	@Override
	public void formatear(String texto) {
		System.out.println("Formateando "+texto+" en PDF");		
	}

}
