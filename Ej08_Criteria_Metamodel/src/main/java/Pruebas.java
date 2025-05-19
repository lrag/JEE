import static org.hibernate.cfg.JdbcSettings.FORMAT_SQL;
import static org.hibernate.cfg.JdbcSettings.HIGHLIGHT_SQL;
import static org.hibernate.cfg.JdbcSettings.SHOW_SQL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.Comercial;
import com.curso.modelo.entidad.DatosBancarios;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.entidad.Producto_Joined;

import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class Pruebas {

	public static void main(String[] args) throws ParseException {

		SessionFactory sf = new Configuration()
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(Comercial.class)
				.addAnnotatedClass(DatosBancarios.class)
				.addAnnotatedClass(Pedido.class)
				.addAnnotatedClass(Producto_Joined.class)
                .setProperty("jakarta.persistence.jdbc.url", "jdbc:h2:file:C:/H2/hibernate6")
                .setProperty("jakarta.persistence.jdbc.user", "sa")
                .setProperty("jakarta.persistence.jdbc.password", "")
                .setProperty(SHOW_SQL, true)
                .setProperty(FORMAT_SQL, false)
                .setProperty(HIGHLIGHT_SQL, true)
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .buildSessionFactory();	
		Session s = sf.openSession();

		
		System.out.println("============================================");
		CriteriaBuilder cb = s.getCriteriaBuilder();
		//La query devuelve objetos del tipo Cliente
		CriteriaQuery<Cliente> cq1 = cb.createQuery(Cliente.class);
		//from Cliente
		Root<Cliente> from1 = cq1.from(Cliente.class);
		//'select c from Cliente c'
		cq1.select(from1);
		
		TypedQuery<Cliente> query1 = s.createQuery(cq1);
		List<Cliente> clientes1 = query1.getResultList();
		clientes1.forEach(c -> System.out.println(c));
		
		System.out.println("============================================");
		//Proyección
		//La query devuelve objetos del tipo String (el nombre del cliente)
		CriteriaQuery<String> cq2 = cb.createQuery(String.class);
		Root<Cliente> from2 = cq2.from(Cliente.class);
		cq2.select(from2.get("nombre"));
		
		TypedQuery<String> query2 = s.createQuery(cq2);
		List<String> clientes2 = query2.getResultList();
		clientes2.forEach(c -> System.out.println(c));		

		
		System.out.println("============================================");
		//select c from Cliente c where c.nombre='Bart' and c.direccion.ciudad='Salamanca'
		CriteriaQuery<Cliente> cq3 = cb.createQuery(Cliente.class);
		Root<Cliente> from3 = cq3.from(Cliente.class);
		cq3.select(from3);
		Predicate p1 = cb.equal(from3.get("nombre"), "Bart");
		Predicate p2 = cb.equal(from3.get("direccion").get("ciudad"), "Salamanca"); //nada de direccion.ciudad
		Predicate p3 = cb.and(p1, p2);
		cq3.where(p3);

		TypedQuery<Cliente> query3 = s.createQuery(cq3);
		List<Cliente> clientes3 = query3.getResultList();
		clientes3.forEach(c -> System.out.println(c));

		
		System.out.println("============================================");
		//select * from productos where precio between 0, 100
		CriteriaQuery<Producto_Joined> cq4 = cb.createQuery(Producto_Joined.class);
		Root<Producto_Joined> from4 = cq4.from(Producto_Joined.class);
		cq4.select(from4);
		
		Predicate p4 = cb.between(from4.get("existencias"), 0, 100);
		cq4.where(p4);

		TypedQuery<Producto_Joined> query4 = s.createQuery(cq4);
		List<Producto_Joined> productos = query4.getResultList();
		productos.forEach(p -> System.out.println(p));
	
		
		System.out.println("============================================");
		//ASOCIACIONES (JOIN)
		//select c from Cliente c join c.pedidos p where p.fecha>01/09/2018 and c.direccion.ciudad = 'Chinchón'
		CriteriaQuery<Cliente> cq5 = cb.createQuery(Cliente.class);
		//from Cliente c
		Root<Cliente> from5 = cq5.from(Cliente.class);
		//select c from Cliente c
		cq5.select(from5);
		
		//El join se hace contra la colección
		//select c from Cliente c join c.pedidos p
		Join<Cliente, Pedido> join = from5.join("pedidos");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		//p.fecha > 01/09/2018
		Predicate p5 = cb.greaterThan(join.get("fecha"), sdf.parse("01/09/2018"));
		Predicate p6 = cb.equal(from5.get("direccion").get("ciudad"), "Chinchón");
		Predicate p7 = cb.and(p5, p6);
		cq5.where(p7);
		
		TypedQuery<Cliente> query5 = s.createQuery(cq5);
		List<Cliente> clientes5 = query5.getResultList();
		clientes5.stream().forEach(c -> System.out.println(c));		
		
		
		System.out.println("============================================");
		//FETCH
		CriteriaQuery<Cliente> cb6 = cb.createQuery(Cliente.class);
		Root<Cliente> from6 = cb6.from(Cliente.class);
		from6.fetch("pedidos");
		cb6.select(from6);		
		
		TypedQuery<Cliente> query6 = s.createQuery(cb6);
		List<Cliente> clientes6 = query6.getResultList();
		clientes6.stream().forEach(c -> System.out.println(c));				
		
		
		
		
		/*
		System.out.println("============================================");
		// Hibernate 4  :)
		//Criteria c1a = s.createCriteria(Cliente.class);
		//c1a.list();

		// JPA criteria :(
		CriteriaBuilder cb = s.getCriteriaBuilder();
		
		CriteriaQuery<Cliente> criteriaQuery1 = cb.createQuery(Cliente.class);
		Root<Cliente> root1 = criteriaQuery1.from(Cliente.class);
		criteriaQuery1.select(root1);
		
		Query<Cliente> query1 = s.createQuery(criteriaQuery1);
		List<Cliente> clientes1 = query1.getResultList();
		clientes1.stream().forEach(c -> System.out.println(c));

		System.out.println("============================================");
		// select c from Cliente c where c.ciudad='Salamanca' AND c.nombre like 'A%'
		// Criteria c2 = s.createCriteria(Cliente.class)
		// .add(Restrictions.like("nombre", "A%"))
		// .add(Restrictions.eq("direccion.ciudad", "Salamanca"));
		// c2.list();

		CriteriaQuery<Cliente> criteriaQuery2 = cb.createQuery(Cliente.class);
		Root<Cliente> root2 = criteriaQuery2.from(Cliente.class);
		criteriaQuery2.select(root2);
		
		Predicate p1 = cb.equal(root2.get("nombre"), "Bart");
		Predicate p2 = cb.equal(root2.get("direccion").get("ciudad"), "Salamanca"); //nada de direccion.ciudad
		Predicate p3 = cb.and(p1, p2);
		criteriaQuery2.where(p3);

		Query<Cliente> query2 = s.createQuery(criteriaQuery2);
		List<Cliente> clientes2 = query2.getResultList();
		clientes2.stream().forEach(c -> System.out.println(c));

		System.out.println("============================================");
		//select p from Producto_Joined p where p.existencas between(1, 100)
		//Criteria c2Bis = s.createCriteria(Producto_Joined.class)
		//	.add(Restrictions.between("existencias", 1.0, 100.0));
		//c2Bis.list();
		
		CriteriaQuery<Producto_Joined> criteriaQuery3 = cb.createQuery(Producto_Joined.class);
		Root<Producto_Joined> root3 = criteriaQuery3.from(Producto_Joined.class);
		criteriaQuery3.select(root3);
		
		Predicate p4 = cb.between(root3.get("existencias"), 0, 100);
		criteriaQuery3.where(p4);

		Query<Producto_Joined> query3 = s.createQuery(criteriaQuery3);
		List<Producto_Joined> productos = query3.getResultList();
		productos.stream().forEach(p -> System.out.println(p));

		System.out.println("============================================");
		//ASOCIACIONES (JOIN)
		//select c from Cliente c join c.facturas...
		//Dame los clientes de Madrid que facturaron el 10/11/2011 
		//Criteria c7 = s.createCriteria(Cliente.class)
		//		.add(Restrictions.eq("direccion.ciudad", "Madrid"))
		//		.createCriteria("facturas") //El join se hace contra la coleccion, no contra la clase
		//			.add(Restrictions.gt("fecha", "2011/11/10"));
		//c7.list();
		
		CriteriaQuery<Cliente> criteriaQuery4 = cb.createQuery(Cliente.class);
		Root<Cliente> root4 = criteriaQuery4.from(Cliente.class);
		criteriaQuery4.select(root4);
		
		Join<Cliente, Pedido> join = root4.join("pedidos");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Predicate p5 = cb.greaterThan(join.get("fecha"), sdf.parse("01/09/2018"));
		criteriaQuery4.where(p5);
		
		Query<Cliente> query4 = s.createQuery(criteriaQuery4);
		List<Cliente> clientes4 = query4.getResultList();
		clientes4.stream().forEach(c -> System.out.println(c));
		
		sf.close();
		*/

	}

}
