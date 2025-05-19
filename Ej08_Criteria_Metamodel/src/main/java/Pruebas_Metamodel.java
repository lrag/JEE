import static org.hibernate.cfg.JdbcSettings.FORMAT_SQL;
import static org.hibernate.cfg.JdbcSettings.HIGHLIGHT_SQL;
import static org.hibernate.cfg.JdbcSettings.SHOW_SQL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.Cliente_;
import com.curso.modelo.entidad.Direccion_;
import com.curso.modelo.entidad.Producto_Joined;
import com.curso.modelo.entidad.Producto_Joined_;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class Pruebas_Metamodel {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration()
				.addAnnotatedClass(Cliente.class)
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
		
		//select c from Cliente c
		
		CriteriaQuery<Cliente> criteriaQuery2 = cb.createQuery(Cliente.class);
		Root<Cliente> from1 = criteriaQuery2.from(Cliente.class);
		criteriaQuery2.select(from1);

		Predicate p1 = cb.equal(from1.get(Cliente_.DIRECCION).get(Direccion_.CIUDAD), "Salamanca"); //nada de direccion.ciudad
		Predicate p2 = cb.equal(from1.get(Cliente_.NOMBRE), "Bart");
		Predicate p3 = cb.and(p1, p2);
		criteriaQuery2.where(p3);

		Query<Cliente> query2 = s.createQuery(criteriaQuery2);
		List<Cliente> clientes2 = query2.getResultList();
		clientes2.stream().forEach(c -> System.out.println(c));

		System.out.println("============================================");
		CriteriaQuery<Producto_Joined> criteriaQuery3 = cb.createQuery(Producto_Joined.class);
		Root<Producto_Joined> root3 = criteriaQuery3.from(Producto_Joined.class);
		criteriaQuery3.select(root3);
		
		Predicate p4 = cb.between(root3.get(Producto_Joined_.EXISTENCIAS), 0, 100);
		criteriaQuery3.where(p4);

		Query<Producto_Joined> query3 = s.createQuery(criteriaQuery3);
		List<Producto_Joined> clientes3 = query3.getResultList();
		clientes3.stream().forEach(p -> System.out.println(p));
		
		sf.close();
		
	}

}





