package com.curso.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.negocio.GestorPeliculasLocal;
import com.curso.modelo.negocio.excepcion.PeliculaException;

@WebServlet("/SVPruebas")
public class SVPruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private GestorPeliculasLocal gestorPeliculas;
	
    public SVPruebas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Pruebas interceptores 
		/*
		try {
			Pelicula p1 = new Pelicula(null, "Die Hard", "John McTiernan", "Accion", "1989");
			Pelicula p2 = new Pelicula(null, "Depredador", "John McTiernan", "Accion", "1989");
			gestorPeliculas.insertar(p1);
			gestorPeliculas.insertar(p2);
			gestorPeliculas.borrar(p1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		
		
		@SuppressWarnings({ "rawtypes", "serial", "unchecked" })
		List<Pelicula> peliculas = new ArrayList() {{
			add(new Pelicula(null, "T1","D1","G1","2001"));
			add(new Pelicula(null, "T2","D2","G2","2002"));
			add(new Pelicula(null, "T3","D3","G3","2003"));
			add(new Pelicula(null, "T4","D4","G4","2004"));
			add(new Pelicula(null, null,"D5","G5","2005"));
		}};
		try {
			gestorPeliculas.insertarPeliculas(peliculas);
		} catch (PeliculaException e) {
			System.out.println("=========================================");
			System.out.println(e.getMessage());
		}
		
		
		gestorPeliculas.listarTodas().forEach( p -> System.out.println(p));
		
		response.getWriter().append("Hola que tal: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}











