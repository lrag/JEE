package negocio;

import java.util.List;

import modelo.Pelicula;
import persistencia.PeliculaDao;

public class GestionPeliculas {

	private PeliculaDao peliculaDao = new PeliculaDao();
	
	public void guardarPelicula(Pelicula pelicula){
		//LN
		if(pelicula.getIdPelicula()==0)				
			peliculaDao.insertar(pelicula);
		else
			peliculaDao.modificar(pelicula);
	}
	
	public void borrarPelicula(Pelicula pelicula){
		peliculaDao.borrar(pelicula);	
	}
	
	public Pelicula buscarPelicula(int idPelicula){
		return peliculaDao.buscar(idPelicula);
	}
	
	public List<Pelicula> listarTodos(){		
		return peliculaDao.listarTodos();
	}	
	
}





