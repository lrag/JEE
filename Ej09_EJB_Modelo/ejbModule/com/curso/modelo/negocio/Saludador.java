package com.curso.modelo.negocio;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

//@Stateless(name="Saludador")
@Singleton(name="Saludador")
@LocalBean
//Pojo
//Acceso p�blico
//Constructor por defecto
//No tiene sentido que tenga constructores con par�metros
public class Saludador implements SaludadorLocal {

    public Saludador() {
    }

    public String saludar(String nombre) {
    	System.out.println("Saludando a "+nombre);
    	return "Hola "+nombre;
    }
    
    
}
