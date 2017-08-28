package de.javaee;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 * Zum testen ob REST überhaupt funktioniert
 * @author Nils
 *
 */
@Path("/")
public class RestTest {
	
	@GET
	@Produces ( MediaType . TEXT_HTML )
	public String asHtml () {
	return
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			+ "<!DOCTYPE html>"
			+ "<html xmlns=\"http://www.w3.org/1999/xhtml\">"
			+ "<head><title> Rest Test </title></head>"
			+ "<body>REST funktioniert</body></html>";
	}
}
