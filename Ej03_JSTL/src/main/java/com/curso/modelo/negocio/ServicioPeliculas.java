package com.curso.modelo.negocio;

import java.util.List;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.persistencia.PeliculaDao;

public class ServicioPeliculas {

	private PeliculaDao peliculaDao = new PeliculaDao();
	
	public void guardar(Pelicula pelicula){
		//LN
		if(pelicula.getIdPelicula()==0)				
			peliculaDao.insertar(pelicula);
		else
			peliculaDao.modificar(pelicula);
	}
	
	public void borrar(Pelicula pelicula){
		peliculaDao.borrar(pelicula);	
	}
	
	public Pelicula buscar(int idPelicula){
		return peliculaDao.buscar(idPelicula);
	}
	
	public List<Pelicula> listarTodos(){		
		return peliculaDao.listarTodos();
	}	
	
}





