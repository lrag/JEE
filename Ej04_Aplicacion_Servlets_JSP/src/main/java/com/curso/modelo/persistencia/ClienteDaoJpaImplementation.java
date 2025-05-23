package com.curso.modelo.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.curso.modelo.entidad.Cliente;

public class ClienteDaoJpaImplementation implements ClienteDao {
	
	public void insertar(Cliente cliente){
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();		
	}
	
	public void modificar(Cliente cliente){
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
		em.close();	
	}
	
	public void borrar(Cliente cliente){
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		em.getTransaction().begin();
		cliente = em.merge(cliente);
		em.remove(cliente);
		em.getTransaction().commit();
		em.close();			
	}
	
	public Cliente buscar(Integer id){
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		Cliente c = em.find(Cliente.class, id);
		em.close();	
		return c;
	}
	
	public List<Cliente> listar(int primero, int cantidad){
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		List<Cliente> clientes = em.createQuery("select c from Cliente c").getResultList();
		em.close();			
		return clientes;
	}
		
}
