package com.curso.modelo.negocio;

import javax.ejb.Local;

@Local
public interface SaludadorLocal {

	public String saludar(String nombre);
	
}
