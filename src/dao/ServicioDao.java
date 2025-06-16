package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Servicio;

public class ServicioDao {
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

	
	public long agregar(Servicio objeto) {
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

	public void actualizar(Servicio objeto) {
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

	public void eliminar(Servicio objeto) {
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
	 
	public Servicio traer(long id) {
		Servicio objeto = null;
		try {
			iniciaOperacion();
			objeto = (Servicio) session.get(Servicio.class, id);
		} finally {
			session.close();
		}
		return objeto;
	}
}
