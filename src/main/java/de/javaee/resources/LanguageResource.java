package de.javaee.resources;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.javaee.entities.Language;
import de.javaee.services.LanguageService;


/**
 * REST resource for {@link Language}.
 *
 * @author Nils Schulist
 */
@Path("/language")
public class LanguageResource {

  @Inject
  private LanguageService languageService;
  
  /**
   * REST get by id method.
   *
   * @param id id of the entity to get.
   * @return The HTTP response Code 200 (OK) if succeeded.
   */  
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Language get(
			@PathParam("id") int id
	) {
		return languageService.find(id);
	}
	
  /**
   * REST get by Name method.
   *
   * @param name name of the entity to get.
   * @return The HTTP response Code 200 (OK) if succeeded.
   */
	@GET
	@Path("/get/name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Language getByName(
			@PathParam("name") String name
	) {
		return languageService.findByName(name);
	}
	
  /**
   * REST post method.
   *
   * @param id id of the entity to update.
   * @param name new languageName
   * @return The HTTP response Code 200 (OK) if succeeded.
   */
	@POST
	@Path("/update/{id}/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response post(
			@PathParam("id") int id,
			@PathParam("name") String name
	) {
		Language language = languageService.find(id);
		language.setName(name);
		languageService.update(language);
		
		return Response.ok().build();
	}
  /**
   * REST put method.
   *
   * @param languageName name of the entity to create.
   * @return The HTTP response Code 200 (OK) if succeeded.
   */	
	@PUT
	@Path("/new/{language}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response put(
			@PathParam("language") String languageName
	) {
		Language language = new Language();
		language.setName(languageName);
		languageService.persist(language);
		
		return Response.ok().build();
	}
	
  /**
   * REST delete method.
   *
   * @param id id of the entity to delete.
   * @return The HTTP response Code 200 (OK) if succeeded.
   */
	@DELETE
	@Path("/delete/{id}")
	public Response delete(
			@PathParam("id") int id
	) {
    languageService.remove(languageService.find(id));
		
    return Response.ok().build();
	}

}
