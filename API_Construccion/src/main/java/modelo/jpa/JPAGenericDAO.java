package modelo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.dao.GenericDAO;

public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID> {

	private Class<T> persistentClass;
	protected EntityManager em;
	
	public JPAGenericDAO(Class<T> persistentClass) {
			this.persistentClass = persistentClass;
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("API_Construccion");
			this.em = emf.createEntityManager();
	}
	
	@Override
	public T getById(ID id) {
		return em.find(persistentClass, id);
	}

	@Override
	public List<T> getAll() {
		return null;
	}

	@Override
	public void create(T entity) {
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			System.out.println("Falllo en CREATE JPA");
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
	}

	@Override
	public void update(T entity) {
		em.getTransaction().begin();
		try {
			em.merge(entity);
			em.getTransaction().commit();
		}
		catch(Exception e) {
			System.out.println("Falllo en UPDATE JPA");
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}	
	}

	@Override
	public void deleteById(ID id) {
		T entity = this.getById(id);
		if(entity != null) {
			try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			}catch(Exception e) {
				System.out.println("Fallo DELETE JPA");
				if(em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
			}
		}
		
	}

}
