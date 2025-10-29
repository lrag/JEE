package com.curso.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.modelo.entidad.Incidencia;
import com.curso.modelo.negocio.ServicioIncidencias;

@WebServlet("/SVIncidencias_SIN_JSP")
public class SVIncidencias_SIN_JSP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServicioIncidencias servicioIncidencias = ServicioIncidencias.getInstancia();	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Incidencia> incidencias = servicioIncidencias.listar();
		
		response.setContentType("text/html");
		response.setCharacterEncoding("iso-8859-1");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<h1 align='center'><font color='lightGreen'>Listado de incidencias</font></h1>");
		out.println("<table align=center border=1>");
		out.println("<tr>");
		out.println("<th>Descipción</th>");
		out.println("<th>Estado</th>");
		out.println("</tr>");
		for(Incidencia i: incidencias){
			out.println("<tr>");
			out.println("<td>"+i.getDescripcion()+"</td>");
			out.println("<td>"+i.getEstado()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	
	}
	
}











