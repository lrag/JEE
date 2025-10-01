package com.curso._01_scopes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SVScopes")
public class SVScopes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject private BeanDependent beanDependent;
	@Inject private BeanRequest beanRequest; 
	@Inject private BeanSession beanSession;
	@Inject private BeanApplication beanApplication;
	
    public SVScopes() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("content-type", "text/html");
		PrintWriter out = response.getWriter();
		out.println("<h3>"+beanDependent+"</h3>");
		out.println("<h3>"+CDI.current().select(BeanDependent.class).get()+"</h3>");
		out.println("<h3>"+CDI.current().select(BeanDependent.class).get()+"</h3>");
		out.println("</div>");
		out.println("<h3>"+beanRequest+"</h3>");
		out.println("<h3>"+CDI.current().select(BeanRequest.class).get()+"</h3>");
		out.println("</div>");
		out.println("<h3>"+beanSession+"</h3>");
		out.println("<h3>"+CDI.current().select(BeanSession.class).get()+"</h3>");
		out.println("</div>");
		out.println("<h3>"+beanApplication+"<h3>");
		out.println("<h3>"+CDI.current().select(BeanApplication.class).get()+"</h3>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
