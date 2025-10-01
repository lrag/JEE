package com.curso.modelo.negocio;

import java.util.List;

import javax.ejb.Local;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.negocio.excepcion.PeliculaException;

@Local
public interface GestorPeliculasLocal {

	void insertar(Pelicula pelicula) throws PeliculaException;
	void insertarPeliculas(List<Pelicula> peliculas) throws PeliculaException;
	void borrar(Pelicula pelicula);
	void modificar(Pelicula pelicula);
	List<Pelicula> listarTodas();
	Pelicula buscar(Integer id);

}
