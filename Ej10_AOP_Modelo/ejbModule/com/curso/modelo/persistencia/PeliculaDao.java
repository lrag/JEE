package com.curso.modelo.persistencia;

import java.util.List;

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

    }

    public void insertar(Pelicula pelicula) {
    	em.persist(pelicula);
    }

    public List<Pelicula> listar(){
    	return em.createQuery("select p from Pelicula p").getResultList();
    }
    
}














