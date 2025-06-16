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
import datos.Contacto;
import datos.Localidad;
import datos.Provincia;

public class ContactoDao {
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

	public long agregar(Contacto objeto) {
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

	public void actualizar(Contacto objeto) {
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

	public void eliminar(Contacto objeto) {
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

	public Contacto traer(long id) {
		Contacto objeto = null;
		try {
			iniciaOperacion();
			objeto = (Contacto) session.get(Contacto.class, id);
		} finally {
			session.close();
		}
		return objeto;
	}
	public  List<Contacto> existeConctacoMail(String email) {
		 List<Contacto> contactos= null;
		try {
			iniciaOperacion();
			contactos =  session.createQuery("FROM Contacto p WHERE LOWER(p.email) = LOWER(:email)",Contacto.class)
					.setParameter("email", email)
					.getResultList();
			// Crea una lista con los nombres en este caso de las provincias que coincidadn sin importar las mayusculas o minusculas
		} finally {
			session.close();
		}
		return contactos;
	}
	
	
	public  List<Contacto> existeDireccionContacto(String email,long idDireccion) {
		 List<Contacto> provincias= null;
		try {
			iniciaOperacion();
			provincias =  session.createQuery("FROM Contacto p WHERE LOWER(p.email) = LOWER(:email) AND p.direccion.id = :idDireccion",Contacto.class)
					.setParameter("idDireccion", idDireccion)
					.setParameter("email", email)
					.getResultList();
			// Crea una lista con los nombres en este caso de las provincias que coincidadn sin importar las mayusculas o minusculas
		} finally {
			session.close();
		}
		return provincias;
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
	public List<Contacto> traer() {
		List<Contacto> lista = new ArrayList<Contacto>();
		try {
			iniciaOperacion();
			Query<Contacto> query = session.createQuery("from Contacto c order by c.email asc, c.mail asc",
					Contacto.class);
			lista = query.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}


}
