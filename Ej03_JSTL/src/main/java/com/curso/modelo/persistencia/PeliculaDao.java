package com.curso.modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import com.curso.modelo.entidad.Pelicula;

public class PeliculaDao {
	
	private static List<Pelicula> peliculas;
	private static int contador;
	
	static {
		peliculas = new ArrayList<>();
		peliculas.add(new Pelicula(1,"Alien","Ridley Scott","CiFi",1979,"Te cagas de miedo."));
		peliculas.add(new Pelicula(2,"Die Hard","John McTiernan","Accion",1988,"Prototipo de las películas de acción"));
		contador = peliculas.size()+1;
	}

	public void insertar(Pelicula pelicula){
		synchronized(this) {
			pelicula.setIdPelicula(contador);
			contador++;
		}
		peliculas.add(pelicula);
		
	}
	
	public void modificar(Pelicula pelicula){
		for(int a=0; a<peliculas.size(); a++) {
			if(peliculas.get(a).getIdPelicula() == pelicula.getIdPelicula()){
				peliculas.set(a, pelicula);
			}
		}
	}

	public void borrar(Pelicula pelicula){
		for(int a=0; a<peliculas.size(); a++) {
			if(peliculas.get(a).getIdPelicula() == pelicula.getIdPelicula()){
				peliculas.remove(a);
			}
		}		
	}

	public Pelicula buscar(int idPelicula){
		for(Pelicula p: peliculas) {
			if(p.getIdPelicula()==idPelicula) {
				return p;
			}
		}
		return null;
	}

	public List<Pelicula> listarTodos(){
		return peliculas;
	}
	
}
