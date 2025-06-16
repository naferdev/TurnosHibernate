package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Lugar;
import datos.Turno;

public class TurnoDao {
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
	
	public long agregar(Turno objeto) {
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

	public void actualizar(Turno objeto) {
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

	public void eliminar(Turno objeto) {
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
	public Turno traer(long id) {
		Turno objeto = null;
		try {
			iniciaOperacion();
			objeto = (Turno) session.get(Turno.class, id);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Turno traerTurnoCompleto (long idTurno) {
		Turno objeto = null;
		 try {
		 iniciaOperacion();
		 String hql = "FROM Turno t JOIN FETCH t.disponibilidad d JOIN FETCH t.profesional p JOIN FETCH t.cliente c JOIN FETCH t.lugar l WHERE t.id = :idTurno";
		 objeto = (Turno) session.createQuery(hql).setParameter("idTurno",
				 idTurno).uniqueResult();
		 } finally {
		 session.close();
		 }
		 return objeto;
    }

}
