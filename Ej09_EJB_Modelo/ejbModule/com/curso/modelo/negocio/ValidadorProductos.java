package com.curso.modelo.negocio;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class ValidadorProductos {

    public ValidadorProductos() {
    }

    public boolean validar(String producto) {
    	return producto.toUpperCase().trim().startsWith("EJB");
    }
    
}
