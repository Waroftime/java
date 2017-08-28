package de.javaee.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * EM service for Entities
 * 
 * @author Nils Schulist
 *
 */
@Stateless
public abstract class EntityService<T> {

	@PersistenceContext
	EntityManager em;

	public void persist(T entity) {
		em.persist(entity);
	}

	public void update(T entity) {
		em.merge(entity);
	}

	public void remove(T entity) {
		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}

	public abstract T find(int id);
	
	public abstract List<T> getEntities();
}
