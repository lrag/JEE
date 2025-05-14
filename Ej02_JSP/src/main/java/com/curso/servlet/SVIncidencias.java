package com.curso.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.modelo.entidad.Incidencia;
import com.curso.modelo.negocio.ServicioIncidencias;

@WebServlet("SVIncidencias")
public class SVIncidencias extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServicioIncidencias servicioIncidencias = new ServicioIncidencias();	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Incidencia> incidencias = servicioIncidencias.listar();
		request.setAttribute("incidencias", incidencias);
		request.getRequestDispatcher("WEB-INF/paginas/listadoIncidencias.jsp").forward(request, response);
	}
	
}
