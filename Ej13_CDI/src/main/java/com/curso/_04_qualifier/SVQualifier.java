package com.curso._04_qualifier;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SVQualifier")
public class SVQualifier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject 
	@QEmisorAvisosCorreoE
	private EmisorAvisos emisor1;
	@Inject 
	@QEmisorAvisosSMS
	private EmisorAvisos emisor2;	
	
    public SVQualifier() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		emisor1.emitir("Aviso 3");
		emisor2.emitir("Aviso 4");
		
		response.addHeader("content-type", "text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>"+emisor1+"</h2>");
		out.println("<h2>"+emisor2+"</h2>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
