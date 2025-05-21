package com.curso.controlador;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.curso.modelo.negocio.GestorPedidosLocal;

@WebServlet("/SVCesta")
public class SVCesta extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//No podemos inyectar así un EJB de sesión con estado porque
	//un servlet es un singleton
	//@EJB
	//private GestorPedidosLocal gestorPedidos;
	
    public SVCesta() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession sesion = request.getSession(true);
		GestorPedidosLocal gpl = (GestorPedidosLocal) sesion.getAttribute("gestorPedidos");
		if(gpl == null) {
			//
			try {
				Context ic = new InitialContext();
				gpl = (GestorPedidosLocal) ic.lookup("java:global/Ej09_EJB_EAR-0.0.1-SNAPSHOT/com.curso-Ej09_EJB_Modelo-0.0.1-SNAPSHOT/GestorPedidos!com.curso.modelo.negocio.GestorPedidos");
				                                      
				sesion.setAttribute("gestorPedidos", gpl);
			} catch (NamingException e) {
				e.printStackTrace();
			} 
		}
		
		request.setAttribute("cesta", gpl.listarCesta());
		request.getRequestDispatcher("cesta.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String producto = request.getParameter("producto");
		
		HttpSession sesion = request.getSession();
		GestorPedidosLocal gpl = (GestorPedidosLocal) sesion.getAttribute("gestorPedidos");
		gpl.addProducto(producto);
		
		response.sendRedirect("SVCesta");

	}

}






