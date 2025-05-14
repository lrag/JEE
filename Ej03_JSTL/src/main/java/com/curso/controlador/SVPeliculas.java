package com.curso.controlador;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.entidad.Usuario;
import com.curso.modelo.negocio.ServicioPeliculas;

@WebServlet("SVPeliculas")
public class SVPeliculas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ServicioPeliculas servicioPeliculas = new ServicioPeliculas();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Pelicula pSel = new Pelicula();
		if("seleccionar".equals(request.getParameter("accion"))) {
			int idPelicula = Integer.parseInt(request.getParameter("idPelicula"));
			pSel = servicioPeliculas.buscar(idPelicula);
			request.setAttribute("pSel",pSel);
		}
		
		List<Pelicula> peliculas = servicioPeliculas.listarTodos();
		request.setAttribute("peliculas", peliculas);
		
		request.getRequestDispatcher("paginaPeliculas.jsp").forward(request,response);				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Vemos el idioma del usuario que está en la sesion:
		HttpSession sesion = request.getSession(false);
		Usuario usr = (Usuario) sesion.getAttribute("usuario");
		
		/*
		//Cargamos el fichero de traducciones:
		ResourceBundle rb = ResourceBundle.
			getBundle("i18n/etiquetas", new Locale(usr.getIdioma()));
		*/
		
		request.getRequestDispatcher("procesarPelicula.jsp").include(request,response);
		Pelicula pelicula = (Pelicula) request.getAttribute("pelicula");
		
		System.out.println(pelicula);

		String accion = request.getParameter("accion");
		
		System.out.println(accion);
		
		ServicioPeliculas gp = new ServicioPeliculas();
		if("guardar".equals(accion)){			
			gp.guardar(pelicula);
		} else if("borrar".equals(accion)){			
			gp.borrar(pelicula);
		}
		
		response.sendRedirect("SVPeliculas");
	}

}











