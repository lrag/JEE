package com.curso._05_produces;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SVProduces")
public class SVProduces extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject 
	@QFormateador
	private Formateador formateador;
	
	@Inject
	@QLogger
	private Logger logger;
	
	@Inject
	@QLoggerError	
	private Logger loggerError;
	
    public SVProduces() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("==============================");
		formateador.formatear("Trololó");

		logger.escribir("Siete caballos vienen de Bonanza");
		loggerError.escribir("ZASCA!");
		
		/*
		Logger log1 = (Logger) CDI.current().select(QLogger.class).get();
		Logger log2 = (Logger) CDI.current().select(QLoggerError.class).get();
		System.out.println("==============================");
		System.out.println(logger);
		System.out.println(log1);
		System.out.println(loggerError);
		System.out.println(log2);
		*/		
		
		response.addHeader("content-type", "text/html");
		PrintWriter out = response.getWriter();
		out.println("<h2>"+formateador+"</h2>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
