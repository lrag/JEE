package com.curso.modelo.negocio;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
//Si es @LocalBean no es necesario implementar una interfaz marcada con @Local
//Este EJB solo podrá inyectarse con @EJB en otro EJB
//y no estará disponible en el JNDI
@LocalBean
public class ValidadorProductos {

    public ValidadorProductos() {
    }

    public boolean validar(String producto) {
    	return producto.toUpperCase().trim().startsWith("EJB");
    }
    
}
