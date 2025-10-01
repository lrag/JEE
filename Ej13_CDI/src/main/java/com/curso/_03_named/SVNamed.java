package com.curso._03_named;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SVNamed")
public class SVNamed extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Aqui no cumplimos la D del SOLID pero no hay duda de que debe inyectarse
	@Inject private EmisorAvisosCorreoE emisorACorreoE;
	@Inject private EmisorAvisosSMS emisorASMS;
	
	@Inject 
	@Named("emisorAvisosCorreoE")
	private EmisorAvisos emisor1;
	@Inject 
	@Named("emisorAvisosSMS")
	private EmisorAvisos emisor2;	
	
    public SVNamed() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		emisorACorreoE.emitir("Aviso 1");
		emisorASMS.emitir("Aviso 2");
		emisor1.emitir("Aviso 3");
		emisor2.emitir("Aviso 4");
		
		response.addHeader("content-type", "text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>"+emisorACorreoE+"</h2>");
		out.println("<h2>"+emisorASMS+"</h2>");
		out.println("<h2>"+emisor1+"</h2>");
		out.println("<h2>"+emisor2+"</h2>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
