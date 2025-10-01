package com.curso.modelo.negocio.excepcion;

//import javax.ejb.ApplicationException;

//Se puede indicar enla excepción si esta hace rollback o no
//@ApplicationException( rollback = true)
public class PeliculaException extends Exception {

	private static final long serialVersionUID = 1L;

	public PeliculaException(String message) {
		super(message);
	}

}

