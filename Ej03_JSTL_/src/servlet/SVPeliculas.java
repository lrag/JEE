package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Pelicula;
import modelo.Usuario;
import negocio.GestionPeliculas;

public class SVPeliculas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SVPeliculas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Vemos el idioma del usuario que está en la sesion:
		HttpSession sesion = request.getSession(false);
		Usuario usr = (Usuario) sesion.getAttribute("usuario");
		//Cargamos el fichero de traducciones:
		ResourceBundle rb = ResourceBundle.
			getBundle("i18n/etiquetas", new Locale(usr.getIdioma()));
		
		request.getRequestDispatcher("procesarPelicula.jsp").
			include(request,response);
		Pelicula pelicula = (Pelicula) request.getAttribute("pelicula");

		String accion = request.getParameter("accion");
		GestionPeliculas gp = new GestionPeliculas();
		Pelicula pSel = new Pelicula();
		if(rb.getString("btn.guardar").equals(accion)){			
			gp.guardarPelicula(pelicula);
			
		} else if(rb.getString("btn.borrar").equals(accion)){			
			gp.borrarPelicula(pelicula);
			
		} else if("seleccionar".equals(accion)){
			pSel = gp.buscarPelicula(pelicula.getIdPelicula());
			
		}
		
		//Preparar los datos para la vista
		List<Pelicula> peliculas = gp.listarTodos();
		request.setAttribute("peliculas", peliculas);
		request.setAttribute("pSel",pSel);
		request.getRequestDispatcher("gestionPeliculas.jsp").forward(request,response);
	}

}











