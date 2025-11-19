package com.curso.modelo.persistencia;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.curso.modelo.entidad.Pelicula;

@Singleton
@LocalBean
public class PeliculaDao {

	@PersistenceContext(unitName="H2PU")	
	private EntityManager em;
	
    public PeliculaDao() {
    	System.out.println("INSTANCIANDO PELICULA_DAO");
    }

    public void insertar(Pelicula pelicula) {
    	em.persist(pelicula);
    }

    public List<Pelicula> listar(){
    	return em.createQuery("select p from Pelicula p").getResultList();
    }
    
}

/*
@Local
interface PeliculaDao_ {
	void insertar(Pelicula pelicula);
}

@Singleton
class PeliculaDaoJPA implements PeliculaDao_ {
	public void insertar(Pelicula pelicula) {
		//em.persist(pelicula);
	}
}

@Singleton
class PeliculaDaoMongoDB implements PeliculaDao_ {
	public void insertar(Pelicula pelicula) {
		//movidas de MongoDB
	}
}

class ServicioPeliculas {	
	@EJB
	private PeliculaDao_ peliculaDao;	
}
*/

























