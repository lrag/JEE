package com.curso;

import javax.enterprise.inject.spi.CDI;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.negocio.ServicioPeliculas;

public class Aplicacion {

	public static void main(String[] args) {
	    Weld weld = new Weld();
	    WeldContainer container = weld.initialize();
	    
	    ServicioPeliculas sp1 = container.select(ServicioPeliculas.class).get();
	    ServicioPeliculas sp2 = container.select(ServicioPeliculas.class).get();
	    //Cuando no tenemos la referencia al Contenedor podemos utilizar el método estático 'CDI.current'
	    ServicioPeliculas sp3 = CDI.current().select(ServicioPeliculas.class).get(); 
	    
	    System.out.println(sp1);
	    System.out.println(sp2);
	    System.out.println(sp3);
	    
	    sp1.altaPelicula(new Pelicula("Tio motosierra"));
	    sp2.altaPelicula(new Pelicula("Alien"));
	    sp3.altaPelicula(new Pelicula("Harry el sucio"));
	    
	    container.shutdown();
	}	
	
}
