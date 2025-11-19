package com.curso._07_aop;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SVAOP")
public class SVAOP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject private ServicioClientes gestorClientes;
	@Inject private ServicioFacturas gestorFacturas;
	
    public SVAOP() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		gestorClientes.insertar("CLIENTE 1");
		gestorClientes.borrar("CLIENTE 2");
		gestorFacturas.insertar("FACTURA 1");
		gestorFacturas.borrar("FACTURA 2");
		
		response.setContentType("text/html");
		response.getWriter().println("<marquee><font color='lightBlue'><h1>Peticion procesada</h1></font></marquee>");
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
