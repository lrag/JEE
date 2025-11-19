package com.curso.modelo.negocio;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptors;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.negocio.aop.InterceptorCronometro;
import com.curso.modelo.negocio.aop.InterceptorLog;
import com.curso.modelo.negocio.excepcion.PeliculaException;
import com.curso.modelo.persistencia.PeliculaDao;

//@Singleton
@Interceptors({ InterceptorLog.class , InterceptorCronometro.class })
public class GestorPeliculas_Limpio implements GestorPeliculasLocal {

	@EJB private PeliculaDao peliculaDao;
	@EJB private GestorPeliculasLocal gestorPeliculas_EJBObj;

	@Override
	@Transactional(value=TxType.REQUIRED, rollbackOn= { PeliculaException.class } )
	public void insertar(Pelicula pelicula) throws PeliculaException {
		System.out.print("GestorPeliculas, insertar:"+pelicula.getTitulo()+"...");
		
		if( pelicula.getTitulo() == null) {
			System.out.println("ERROR!");
			throw new PeliculaException("El titulo es obligatorio");
		}
		System.out.println("OK");
		peliculaDao.insertar(pelicula);
	}
	
	@Transactional(value=TxType.REQUIRED, rollbackOn= { PeliculaException.class } )
	public void insertarPeliculas(List<Pelicula> peliculas) throws PeliculaException{
		//OTRAS CONSULTAS
		for(Pelicula pAux: peliculas) {
			try {
				gestorPeliculas_EJBObj.insertar(pAux);
			} catch (PeliculaException e) {
				System.out.println("Una película no se ha insertado");
			}
		}
	}
		
	@Override
	@Transactional(value=TxType.REQUIRED, rollbackOn= { PeliculaException.class } )
	public void modificar(Pelicula pelicula) {

	}

	@Override
	@Transactional(value=TxType.REQUIRED, rollbackOn= { PeliculaException.class } )
	public void borrar(Pelicula pelicula) {
		System.out.println("GestorPeliculas, borrar:"+pelicula.getTitulo());
		try {
			Thread.sleep(2000);
			//LN PARA BORRAR EL PRODUCTO...
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional(value=TxType.SUPPORTS )
	public Pelicula buscar(Integer id) {
		return null;
	}

	@Override
	@Transactional(value=TxType.SUPPORTS )
	public List<Pelicula> listarTodas() {
		return peliculaDao.listar();
	}

}
