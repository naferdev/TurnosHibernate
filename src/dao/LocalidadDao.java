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
import datos.Localidad;
import datos.Provincia;

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
	 public Localidad traerLocalidadYProvincia(long idLocalidad) throws HibernateException {
		 Localidad objeto = null;
		 try {
		 iniciaOperacion();
		 String hql = "from Localidad c inner join fetch c.provincia where c.id = :id";
		 objeto = (Localidad) session.createQuery(hql).setParameter("id",
				 idLocalidad).uniqueResult();
		 } finally {
		 session.close();
		 }
		 return objeto;
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
	

	public List<Localidad> traer() {
		List<Localidad> lista = new ArrayList<Localidad>();
		try {
			iniciaOperacion();
			Query<Localidad> query = session.createQuery("from Localidad c inner join fetch c.provincia order by c.nombre asc",
					Localidad.class);
			lista = query.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	public  List<Localidad> existeLocalidadConNombre(String nombre) {
	
		 List<Localidad> localidades= new ArrayList<>();;
		try {
			iniciaOperacion();
			localidades =  session.createQuery("FROM Localidad p WHERE LOWER(p.nombre) = LOWER(:nombre)",Localidad.class)
					.setParameter("nombre", nombre)
					.getResultList();
			// Crea una lista con los nombres en este caso de las provincias que coincidadn sin importar las mayusculas o minusculas
		} finally {
			session.close();
		}
		return localidades;
	}

}
