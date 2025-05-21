package com.curso.modelo.negocio;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

//@Stateful
@Stateless(name="Saludador")
//Esta EJB estaría mejor como un singleton 
//@Singleton(name="Saludador")

//@LocalBean
//Pojo
//Acceso público
//Constructor por defecto
//No tiene sentido que tenga constructores con parámetros
public class Saludador implements SaludadorLocal {

    public Saludador() {
    	System.out.println("Instanciando Saludador");
    }

    public String saludar(String nombre) {
    	System.out.println("Saludando a "+nombre);
    	return "Hola "+nombre;
    }
        
}
