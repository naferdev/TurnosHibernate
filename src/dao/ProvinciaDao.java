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
import datos.Provincia;

public class ProvinciaDao {
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

	public long agregar(Provincia objeto) {
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

	public void actualizar(Provincia objeto) {
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

	public void eliminar(Provincia objeto) {
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
	public Provincia traerXnombre(String nombre) {
		Provincia provincia = null;
		try {
			iniciaOperacion();
			provincia = (Provincia) session.createQuery("from Provincia c where LOWER(c.nombre) = LOWER(:nombre)")
					.setParameter("nombre", nombre)
					.uniqueResult();
			 if (provincia == null) {
		            throw new IllegalArgumentException("Provincia con nombre '" + nombre + "' no encontrada.");
		        }
		} finally {
			session.close();
		}
		return provincia;
		
	}
	
	
	
	public Provincia traer(long id) {
		Provincia objeto = null;
		try {
			iniciaOperacion();
			objeto = (Provincia) session.get(Provincia.class, id);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public  List<Provincia> existeProvinciaConNombre(String nombre) {
		 List<Provincia> provincias= new ArrayList<>();
		try {
			iniciaOperacion();
			provincias =  session.createQuery("FROM Provincia p WHERE LOWER(p.nombre) = LOWER(:nombre)",Provincia.class)
					.setParameter("nombre", nombre)
					.getResultList();
			// Crea una lista con los nombres en este caso de las provincias que coincidadn sin importar las mayusculas o minusculas
		} finally {
			session.close();
		}
		return provincias;
	}
	
	
	
	public List<Provincia> traer() {
		List<Provincia> lista = new ArrayList<Provincia>();
		try {
			iniciaOperacion();
			Query<Provincia> query = session.createQuery("from Provincia c order by c.nombre asc, c.nombre asc",
					Provincia.class);
			lista = query.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}


}
