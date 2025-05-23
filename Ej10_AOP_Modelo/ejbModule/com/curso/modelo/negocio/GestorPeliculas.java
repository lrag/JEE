package com.curso.modelo.negocio;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.curso.modelo.entidad.Pelicula;
import com.curso.modelo.negocio.aop.InterceptorCronometro;
import com.curso.modelo.negocio.aop.InterceptorLog;
import com.curso.modelo.negocio.excepcion.PeliculaException;
import com.curso.modelo.persistencia.PeliculaDao;

@Singleton
//@LocalBean
@Interceptors({ InterceptorLog.class, InterceptorCronometro.class })
public class GestorPeliculas implements GestorPeliculasLocal {

	@Resource
	private SessionContext sCtx;
		
	@EJB
	private PeliculaDao peliculaDao;
	
	public GestorPeliculas() {
		System.out.println("INSTANCIANDO GESTOR_PELICULAS");
	}
	
	@Override
	//@Interceptors({ InterceptorLog.class, InterceptorCronometro.class })
	//@Transactional(value=TxType.REQUIRES_NEW, rollbackOn= { PeliculaException.class } )
	@Transactional(value=TxType.REQUIRED, rollbackOn= { PeliculaException.class } )
	public void insertar(Pelicula pelicula) throws PeliculaException {
		
		System.out.println("HABER SI DESPLIEGA ESTO");
		
		System.out.print("GestorPeliculas, insertar:"+pelicula.getTitulo()+"...");
		
		if( pelicula.getTitulo() == null) {
			System.out.println("ERROR!");
			
			//Set rollback only es definitio: no podemos retractarnos
			//sCtx.setRollbackOnly();
			
			//Mejor controlarlo con excepciones
			throw new PeliculaException("El titulo es obligatorio");
			
			//boolean x = sCtx.getRollbackOnly();
		}
		System.out.println("OK");
		peliculaDao.insertar(pelicula);
	}

	/*
	@Transactional(value=TxType.REQUIRED, rollbackOn= { PeliculaException.class } )
	public void insertarPeliculas(List<Pelicula> peliculas) throws PeliculaException{
		for(Pelicula pAux: peliculas) {
			this.insertar(pAux);
		}
	}
	*/
	
	@Transactional(value=TxType.REQUIRED, rollbackOn= { PeliculaException.class } )
	public void insertarPeliculas(List<Pelicula> peliculas) throws PeliculaException{
		for(Pelicula pAux: peliculas) {
			
			//Si invocamos el metodo 'insertar' sin pasar por el ejb object
			//cualquier anotación que tenga se ignorará
			//this.insertar(pAux);
			
			//Obtenemos el ejbObj del session context
			
			System.out.println("=========================================");
			System.out.println(sCtx.getBusinessObject(GestorPeliculasLocal.class));
			
			//Podríamos (deberíamos) declarar el EJBObject como un atributo de la clase)
			GestorPeliculasLocal ejbObj = (GestorPeliculasLocal) sCtx.getBusinessObject(GestorPeliculasLocal.class);
			ejbObj.insertar(pAux);
			
			//Mejor controlamos la detencion del proceso con excepciones
			//if(sCtx.getRollbackOnly()) {
			//	break;
			//}			
			
		}
	}
	
	
	@Override
	public void modificar(Pelicula pelicula) {

	}

	@Override
	public void borrar(Pelicula pelicula) {
		System.out.println("GestorPeliculas, borrar:"+pelicula.getTitulo());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Pelicula buscar(Integer id) {
		return null;
	}

	@Override
	public List<Pelicula> listarTodas() {
		return peliculaDao.listar();
	}

}
