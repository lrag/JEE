package com.curso.modelo.entidad;

import java.io.Serializable;

public class Pelicula implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idPelicula;
	private String titulo;
	private String director;
	private String genero;
	private int year;
	private String observaciones;

	public Pelicula() {
		super();
	}

	public Pelicula(int idPelicula, String titulo, String director,
			String genero, int year, String observaciones) {
		super();
		this.idPelicula = idPelicula;
		this.titulo = titulo;
		this.director = director;
		this.genero = genero;
		this.year = year;
		this.observaciones = observaciones;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "Pelicula [director=" + director + ", genero=" + genero
				+ ", idPelicula=" + idPelicula + ", observaciones="
				+ observaciones + ", titulo=" + titulo + ", year=" + year + "]";
	}

}
