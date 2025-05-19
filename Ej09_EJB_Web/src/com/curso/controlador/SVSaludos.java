package com.curso.controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.modelo.negocio.SaludadorLocal;

@WebServlet("/SVSaludos")
public class SVSaludos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(name="Saludador")
	private SaludadorLocal saludador;
	
    public SVSaludos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<marquee><h2><font color='lightGreen'>"+saludador.saludar("Luis Ramón")+"</font></h2></marquee>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
