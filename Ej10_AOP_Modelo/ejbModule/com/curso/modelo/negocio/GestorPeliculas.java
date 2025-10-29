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

@Singleton
//@LocalBean
@Interceptors({ InterceptorLog.class , InterceptorCronometro.class })
public class GestorPeliculas implements GestorPeliculasLocal {

	@Resource
	private SessionContext sCtx;
	
	private GestorPeliculasLocal ejbObj;
			
	@EJB
	private PeliculaDao peliculaDao;
	
	@EJB
	private GestorPeliculasLocal gestorPeliculas_EJBObj;
	
	public GestorPeliculas() {
		System.out.println("INSTANCIANDO GESTOR_PELICULAS");
		//Demasiado pronto para esto
		//ejbObj = sCtx.getBusinessObject(GestorPeliculasLocal.class);
	}

	@PostConstruct
	public void init() {
		ejbObj = sCtx.getBusinessObject(GestorPeliculasLocal.class);
	}	
	
	@Override
	//@Interceptors({ InterceptorLog.class, InterceptorCronometro.class })
	//@Transactional(value=TxType.REQUIRED, rollbackOn={ PeliculaException.class } )
	@Transactional(value=TxType.REQUIRES_NEW, rollbackOn= { PeliculaException.class } )
	public void insertar(Pelicula pelicula) throws PeliculaException {
		
		System.out.print("GestorPeliculas, insertar:"+pelicula.getTitulo()+"...");
		
		if( pelicula.getTitulo() == null) {
			System.out.println("ERROR!");
			//Set rollback only es definitio: no podemos retractarnos
			//sCtx.setRollbackOnly();
			//boolean x = sCtx.getRollbackOnly();
			//return;
			
			//Mejor controlarlo con excepciones
			throw new PeliculaException("El titulo es obligatorio");
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
		
		//OTRAS CONSULTAS
		
		for(Pelicula pAux: peliculas) {
			
			//Si invocamos el metodo 'insertar' sin pasar por el ejb object
			//cualquier anotación que tenga se ignorará
			//
			//this.insertar(pAux);
			//			
			
			//Podemos obtener la referencia al EJBObj con un lookup al directorio JNDI (así era hasta la versión 2.1
			//Context ic = new InitialContext();
			//GestorPeliculasLocal gpl = (GestorPeliculasLocal) ic.lookUp("....chorizo del jsoss");
			//gpl.insertar(pAux)
			
			//Podemos obtener el ejbObj del session context
			//Si quisieramos esto el mejor lugar para colocar el código sería el @PostConstruct
			//System.out.println("=========================================");
			//System.out.println(sCtx.getBusinessObject(GestorPeliculasLocal.class));
			//GestorPeliculasLocal gpl = sCtx.getBusinessObject(GestorPeliculasLocal.class);
			//gpl.insertar(pAux);
			
			//Y podemos (la mejor opción) obtener la referencia al EJBObje con @EJB
			try {
				gestorPeliculas_EJBObj.insertar(pAux);
			} catch (PeliculaException e) {
				System.out.println("Una película no se ha insertado");
			}

			//Mejor controlamos la detencion del proceso con excepciones
			//if(sCtx.getRollbackOnly()) {
			//	break;
			//}			
			
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

/*
@Transactional
class ServicioPeliculas {
	
	public void insertar() {}
	public void modificar() {}
	public void otraCosa() {}
	public void borrar() {}
	
	@Transactional(value = TxType.SUPPORTS)
	public void buscar() {}
	@Transactional(value = TxType.SUPPORTS)
	public void listar() {}
		
}
*/

/*
class InterceptorTransacciones {

	@PresistenceContex
	private EntityManager em;

	@AroundInvoke
	public Object tx(InvocationContext iCtx) throws Exception {
		
		//Averiguamos si el método que va a invocarse tiene la anotación @Transactional
		iCtx.getMethod().getAnotaciones
		//Si la tiene se examina para ver el valor de la propagación

		Object retorno = null
		try {		
			em.getTransaction.begin();
			//Se invoca al target
			retorno = iCtx.proceed()
			if( getRollbackOnly() == true ){
				em.getTransaction.rollback();
			} else {
				em.getTransaction.commit()
			}		
		} catch (Exception e){
			em.getTransaction.rollback();
			throw
		}
		
	}
	
	return retorno	
}
*/

