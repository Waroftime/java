package de.javaee.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import de.javaee.entities.Language;
/**
 * Service for Entity Language
 * @author Nils Schulist
 *
 */
@Stateless
public class LanguageService extends EntityService<Language> {
	
  public LanguageService() {

  }
  
  /** Returns a Entity with a specific id.
   * @return the language Entity
   */
  @Override
  public Language find(int id) {
    return em.find(Language.class, id);
  }
  
  /**
   * Return all entities for {@link Language}.
   * @return All entities for Language from the database.
   */
	@Override
	public List<Language> getEntities() {
    TypedQuery<Language> query = em.createQuery("SELECT l FROM Language l", Language.class);
    return query.getResultList();
	}
  /**
   * Searches for a {@link Language} inside the database.
   *
   * @param name name of the Language.
   * @return The Language with the corresponding name or null if none found.
   */
  public Language findByName(String name) {
    TypedQuery<Language> query = 
    		em.createQuery("SELECT l FROM Language l " + "WHERE l.name = :name", Language.class);
    query.setParameter("name", name);

    List<Language> results = query.getResultList();
    return results.size() > 0 ? results.get(0) : null;
  }
   
}
