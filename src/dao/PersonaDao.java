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
import datos.Contacto;
import datos.Localidad;
import datos.Persona;
import datos.Profesional;
import datos.Provincia;

public class PersonaDao {
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

	public long agregar(Persona objeto) {
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

	public void actualizar(Persona objeto) {
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

	public void eliminar(Persona objeto) {
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

	public Persona traer(long id) {
		Persona objeto = null;
		try {
			iniciaOperacion();
			objeto = (Persona) session.get(Persona.class, id);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Persona traerXdni(int dni) {	
		Persona persona = null;
		try {
			iniciaOperacion();
			persona = (Persona) session.createQuery("from Persona c where c.dni = :dni")
					.setParameter("dni", dni)
					.uniqueResult();
			 Hibernate.initialize(persona.getContacto());

	            if (persona instanceof Cliente) {
	                Hibernate.initialize(((Cliente) persona).getLstTurnos());
	            }

	            if (persona instanceof Profesional) {
	                Profesional p = (Profesional) persona;
	                Hibernate.initialize(p.getEspecialidad());
	                Hibernate.initialize(p.getLugar());
	                Hibernate.initialize(p.getDisponibilidades());
	                Hibernate.initialize(p.getServicios());
	            }
	        
		} finally {
			session.close();
		}
		return persona;
	}
	
	public Persona traerXmatricula(Integer matricula) {
		Persona persona = null;
		try {
			iniciaOperacion();
			persona = (Persona) session.createQuery("from Persona c where c.matricula = :matricula")
					.setParameter("matricula", matricula)
					.uniqueResult();
			 Hibernate.initialize(persona.getContacto());

	            if (persona instanceof Cliente) {
	                Hibernate.initialize(((Cliente) persona).getLstTurnos());
	            }

	            if (persona instanceof Profesional) {
	                Profesional p = (Profesional) persona;
	                Hibernate.initialize(p.getEspecialidad());
	                Hibernate.initialize(p.getLugar());
	                Hibernate.initialize(p.getDisponibilidades());
	                Hibernate.initialize(p.getServicios());
	            }
	        
		} finally {
			session.close();
		}
		return persona;
	}
	
	
	
	public  List<Persona> existePersona(int dni) {
		 List<Persona> personas= null;
		try {
			iniciaOperacion();
			personas =  session.createQuery("FROM Persona p WHERE p.dni = :dni",Persona.class)
					.setParameter("dni", dni)
					.getResultList();
			// Crea una lista con los nombres en este caso de las provincias que coincidadn sin importar las mayusculas o minusculas
		} finally {
			session.close();
		}
		return personas;
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
	public List<Persona> traer() {
		List<Persona> lista = new ArrayList<Persona>();
		try {
			iniciaOperacion();
			Query<Persona> query = session.createQuery("from Persona c order by c.nombre asc, c.nombre asc",
					Persona.class);
			lista = query.getResultList();
			
			
			 for (Persona persona : lista) {
				   if (persona.getContacto() != null) {
				        Hibernate.initialize(persona.getContacto());
				        Hibernate.initialize(persona.getContacto().getDireccion());
				    }
		      
		            if (persona instanceof Cliente) {
		                Hibernate.initialize(((Cliente) persona).getLstTurnos());
		            }

		            if (persona instanceof Profesional) {
		                Profesional p = (Profesional) persona;
		                Hibernate.initialize(p.getEspecialidad());
		                Hibernate.initialize(p.getLugar());
		                Hibernate.initialize(p.getDisponibilidades());
		                Hibernate.initialize(p.getServicios());
		            }
		        }
			
			
		} finally {
			session.close();
		}
		return lista;
	}


}
