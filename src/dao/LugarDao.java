package dao;

import java.sql.Time;
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
import datos.Lugar;
import datos.Provincia;

public class LugarDao {
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

	
	public long agregar(Lugar objeto) {
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

	public void actualizar(Lugar objeto) {
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

	public void eliminar(Lugar objeto) {
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
	 public Lugar traerLugarYDireccion(long idLugar) throws HibernateException {
		 Lugar objeto = null;
		 try {
		 iniciaOperacion();
		 String hql = "FROM Lugar l JOIN FETCH l.direccion WHERE l.id = :idLocalidad";
		 objeto = (Lugar) session.createQuery(hql).setParameter("idLocalidad",
				 idLugar).uniqueResult();
		 } finally {
		 session.close();
		 }
		 return objeto;
		 }
	 
	 
	 

	public Lugar traer(long id) {
		Lugar objeto = null;
		try {
			iniciaOperacion();
			objeto = (Lugar) session.get(Lugar.class, id);
		} finally {
			session.close();
		}
		return objeto;
	}
	

	public List<Lugar> traer() {
		List<Lugar> lista = new ArrayList<Lugar>();
		try {
			iniciaOperacion();
			Query<Lugar> query = session.createQuery( "from Lugar c inner join fetch c.direccion order by  c.direccion.calle  asc",
					Lugar.class);
			lista = query.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	
	public  List<Lugar> existeDireccionConLugar(Time horarioApertura,long idDireccion) {
		 List<Lugar> lugares= null;
		try {
			iniciaOperacion();
			lugares =  session.createQuery("FROM Lugar p WHERE p.direccion.id  = :idDireccion AND p.horarioApertura = :horarioApertura",Lugar.class)
					.setParameter("idDireccion", idDireccion)
					.setParameter("horarioApertura", horarioApertura)
					.getResultList();
			// Crea una lista con los nombres en este caso de las provincias que coincidadn sin importar las mayusculas o minusculas
		} finally {
			session.close();
		}
		return lugares;
	}

	
}
