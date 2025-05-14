package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;

public class SVLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SVLogin() {
        super();
    }
    
    public void init(){
    	
    	//Hay lugares mejores para esto.
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String login = request.getParameter("login");
		String pw    = request.getParameter("pw");
		
		Usuario usr = buscarUsuario(login,pw);
		if(usr!=null){
			//Obtenemos una sesión utilizando el objeto request
			HttpSession sesion = request.getSession(true);
			//Dejamos el usuario como atributo en el request:
			sesion.setAttribute("usuario",usr);
			request.getRequestDispatcher("SVPeliculas").forward(request,response);
		} else {
			response.sendRedirect("login.html");
		}
	
	}
	
	private Usuario buscarUsuario(String login, String pw){
		
		Usuario usr = null;
		
		Connection cx = null;
		try {
			cx = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/bbdd","root","root");
			
			//Statement st = cx.createStatement();
			//st.executeQuery("select * from usuarios where login='"+login+"' and pw='"+pw+"'");
			PreparedStatement pst = 
				cx.prepareStatement("select * from usuarios where login=? and pw=?");
			pst.setString(1, login);
			pst.setString(2, pw);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				usr = new Usuario(rs.getInt("id_usuario"),
								  rs.getString("nombre"),
								  rs.getString("login"),
								  rs.getString("pw"),
								  rs.getString("idioma"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return usr;
	}

}







