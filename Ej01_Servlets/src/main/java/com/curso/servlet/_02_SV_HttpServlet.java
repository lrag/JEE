package com.curso.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controladores/Servlet")
public class _02_SV_HttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public _02_SV_HttpServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//hora inicio
		
		try {
			Thread.sleep(5_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//ESCRIBIR EN EL LOG
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ESCRIBIR EN EL LOG
		doGet(request, response);
	}

}
