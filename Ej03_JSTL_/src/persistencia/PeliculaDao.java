package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Pelicula;

public class PeliculaDao {

	public void insertar(Pelicula p){
		
		Connection cx = null;
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbdd","root","root");
			PreparedStatement pst = cx.prepareStatement("insert into peliculas (titulo,director,genero,year,observaciones) values (?,?,?,?,?)");
			pst.setString(1, p.getTitulo());
			pst.setString(2, p.getDirector());
			pst.setString(3, p.getGenero());
			pst.setInt(4, p.getYear());
			pst.setString(5, p.getObservaciones());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void modificar(Pelicula p){

		Connection cx = null;
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbdd","root","root");
			PreparedStatement pst = cx.prepareStatement("update peliculas set titulo=?,director=?,genero=?,year=?,observaciones=? where id_pelicula=?");
			pst.setString(1, p.getTitulo());
			pst.setString(2, p.getDirector());
			pst.setString(3, p.getGenero());
			pst.setInt(4, p.getYear());
			pst.setString(5, p.getObservaciones());
			pst.setInt(6, p.getIdPelicula());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void borrar(Pelicula p){
		
		Connection cx = null;
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbdd","root","root");
			PreparedStatement pst = cx.prepareStatement("delete from peliculas where id_pelicula=?");
			pst.setInt(1, p.getIdPelicula());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public Pelicula buscar(int idPelicula){
		
		Pelicula p = null;
		Connection cx = null;
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbdd","root","root");
			PreparedStatement pst = cx.prepareStatement("select * from peliculas where id_pelicula=?");
			pst.setInt(1, idPelicula);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				p = new Pelicula(idPelicula, 
								 rs.getString("titulo"),
								 rs.getString("director"),
								 rs.getString("genero"),
								 rs.getInt("year"),
								 rs.getString("observaciones"));
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
		
		return p;
		
	}

	public List<Pelicula> listarTodos(){

		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		Connection cx = null;
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbdd","root","root");
			PreparedStatement pst = cx.prepareStatement("select * from peliculas");
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				Pelicula p = new Pelicula(rs.getInt("id_pelicula"), 
								 rs.getString("titulo"),
								 rs.getString("director"),
								 rs.getString("genero"),
								 rs.getInt("year"),
								 rs.getString("observaciones"));
				peliculas.add(p);
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
		
		return peliculas;
	}
	
}
