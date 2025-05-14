package com.curso.controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.curso.modelo.entidad.Usuario;
import com.curso.modelo.negocio.ServicioUsuarios;

@WebServlet("SVLogin")
public class SVLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServicioUsuarios servicioUsuarios = new ServicioUsuarios();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String login = request.getParameter("login");
		String pw    = request.getParameter("pw");
		
		Usuario usr = servicioUsuarios.buscarPorLogin(login,pw);
		if(usr!=null){
			//Obtenemos una sesión utilizando el objeto request
			HttpSession sesion = request.getSession(true);
			//Dejamos el usuario como atributo en la sesión:
			usr.setPw(null);
			sesion.setAttribute("usuario",usr);
			response.sendRedirect("SVPeliculas");
		} else {
			response.sendRedirect("login.html");
		}
	
	}

}







