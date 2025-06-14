package dao;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import datos.Cliente;
import datos.Localidad;

public class LocalidadDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public long agregar(Localidad objeto) {
		long id = 0;
		try {
			iniciaOperacion();
			 id = (Long) session.save(objeto);;
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(Localidad objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public void eliminar(Localidad objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public Localidad traer(long id) {
		Localidad objeto = null;
		try {
			iniciaOperacion();
			objeto = (Localidad) session.get(Localidad.class, id);
		} finally {
			session.close();
		}
		return objeto;
	}
/*
	public Cliente traer(int dni) {
		Cliente cliente = null;
		try {
			iniciaOperacion();
			cliente = (Cliente) session.createQuery("from Cliente c where c.dni = :dni")
					.setParameter("dni", dni)
					.uniqueResult();
			// En este caso :dni es un marcador de posición para el parámetro.
			// Al utilizar el método setParameter para asignar el valor del parámetro dni.
			// Esto ayuda a prevenir la inyección de SQL.
		} finally {
			session.close();
		}
		return cliente;
	}
*/
	public List<Localidad> traer() {
		List<Localidad> lista = new ArrayList<Localidad>();
		try {
			iniciaOperacion();
			Query<Localidad> query = session.createQuery("from Localidad c order by c.nombre asc, c.nombre asc",
					Localidad.class);
			lista = query.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}


}
