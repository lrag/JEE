package com.curso.controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.modelo.negocio.GestorPedidosLocal;
import com.curso.modelo.negocio.SaludadorLocal;

@WebServlet("/SVSaludos")
public class SVSaludos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Podemos utilizar @EJB en:
	//Un ejb
	//Un servlet/filtro/oyente
	//Una backing bean de JSF
	//Un @WebService de JAX-WS
	//Un endpoint de JAX-RS
	//
	//Resumen:
	//En cualquier otr aclase manejada por el servidor JEE
	
	@EJB(name="Saludador")
	private SaludadorLocal saludador;
	
    public SVSaludos() {
        super();
        
		/*
		try {
			System.out.println(">>CONECTANDO CON EL DIRECTORIO JNDI>>>>>>>>>>>>>>>>>>>>>>>>");
			Context ic = new InitialContext();
			saludador = (SaludadorLocal) ic.lookup("java:global/Ej09_EJB_EAR-0.0.1-SNAPSHOT/com.curso-Ej09_EJB_Modelo-0.0.1-SNAPSHOT/Saludador!com.curso.modelo.negocio.SaludadorLocal");
		} catch (NamingException e) {
			e.printStackTrace();
		} 
		*/
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("<marquee><h2><font color='lightGreen'>"+saludador.saludar("Luis Ramón")+"</font></h2></marquee>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
