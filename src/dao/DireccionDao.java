package dao;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import datos.Cliente;
import datos.Direccion;
import datos.Localidad;
import datos.Provincia;

public class DireccionDao {
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

	
	public long agregar(Direccion objeto) {
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

	public void actualizar(Direccion objeto) {
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

	public void eliminar(Direccion objeto) {
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
	 public Direccion traerDireccionLocalidadYProvincia(long idLocalidad) throws HibernateException {
		 Direccion objeto = null;
		 try {
		 iniciaOperacion();
		 String hql = "FROM Direccion d " +
                 "JOIN FETCH d.localidad l " +
                 "JOIN FETCH l.provincia " +
                 "WHERE l.id = :idLocalidad";
		 objeto = (Direccion) session.createQuery(hql).setParameter("idLocalidad",
				 idLocalidad).uniqueResult();
		 } finally {
		 session.close();
		 }
		 return objeto;
		 }
	 
	 
	 

	public Direccion traer(long id) {
		Direccion objeto = null;
		try {
			iniciaOperacion();
			objeto = (Direccion) session.get(Direccion.class, id);
		} finally {
			session.close();
		}
		return objeto;
	}
	

	public List<Direccion> traer() {
		List<Direccion> lista = new ArrayList<Direccion>();
		try {
			iniciaOperacion();
			Query<Direccion> query = session.createQuery( "from Direccion c " +
				    "inner join fetch c.provincia " +
				    "inner join fetch c.localidad " +
				    "order by c.calle asc",
					Direccion.class);
			lista = query.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	public  List<Direccion> existeDireccionConNombre(String calle,Integer altura) {
		 List<Direccion> direcciones= null;
		try {
			iniciaOperacion();
			direcciones =  session.createQuery("FROM Direccion p WHERE LOWER(p.calle) = LOWER(:calle) AND p.altura = :altura",Direccion.class)
					.setParameter("calle", calle)
					.setParameter("altura", altura)
					.getResultList();
			// Crea una lista con los nombres en este caso de las provincias que coincidadn sin importar las mayusculas o minusculas
		} finally {
			session.close();
		}
		return direcciones;
	}

}
