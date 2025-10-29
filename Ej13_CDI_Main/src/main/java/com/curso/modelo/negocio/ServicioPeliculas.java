package com.curso.modelo.negocio;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.repositorio.PeliculaRepositorio;

@ApplicationScoped
public class ServicioPeliculas {

	@Inject 
	private PeliculaRepositorio peliculaRepo;
	
	@PostConstruct
	public void inicializar() {
		System.out.println("POST CONSTRUCT DE ServicioPeliculas");
	}

	@PreDestroy
	public void finalizar() {
		System.out.println("PRE DESTROY DE ServicioPeliculas");
	}	
	
	public ServicioPeliculas() {
		//peliculaRepo = CDI.current().select(PeliculaRepositorio.class).get();
	}	

	public void altaPelicula(Pelicula pelicula) {
		System.out.println("Alta película");
		peliculaRepo.save(pelicula);
	}
	
}
