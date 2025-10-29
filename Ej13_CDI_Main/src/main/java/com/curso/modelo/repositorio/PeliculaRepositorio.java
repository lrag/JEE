package com.curso.modelo.repositorio;

import javax.enterprise.context.ApplicationScoped;
import com.curso.modelo.entidad.Pelicula;

//@Dependent (o no poner nada)
//@RequestScoped
//@SessionScoped
@ApplicationScoped
public class PeliculaRepositorio {

	public void save(Pelicula pelicula) {
		System.out.println(this+", Guardando la película "+pelicula);
	}
	
}
