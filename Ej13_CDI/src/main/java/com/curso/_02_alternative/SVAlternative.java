package com.curso._02_alternative;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SVAlternative")
public class SVAlternative extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Cual se debe inyectar aquí???
	@Inject private ClienteDao clienteDao;
	
	//Aqui no hay ninguna duda, pero no cumplimos la D del SOLID
	//@Inject private ClienteDaoJDBCImplementation clienteDao2;
	
    public SVAlternative() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		clienteDao.insertar("Hal 9000");
		
		response.addHeader("content-type", "text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>"+clienteDao+"</h2>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
