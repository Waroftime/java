package de.javaee;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import de.javaee.entities.*;
import de.javaee.services.*;

@Named
@RequestScoped
public class EntityView {
	// Services 
	@Inject
	private LanguageService languageService;

	// Models
	private DataModel<Language> languageModel;	

	
	/**
	 * Receives the DataModels from an Instance.
	 * 
	 * @param <T> The Entity
	 * @param eS EntityService for an Entity.
	 * @param dm DataModel for an Entity.
	 * @return ListDataModel for the Entity.
	 */
	// This Function is to reduce the lines of code for the DataModels.
	public <T> DataModel<T> getModel(EntityService<T> eS, DataModel<T> dm) {
		if (dm == null) {
			dm = new ListDataModel<T>(eS.getEntities());
		}
		return dm;
	}
	
	// GET Methoden for DataModels
	public DataModel<Language> getLanguageModel() {
	    return getModel(languageService, languageModel);
	}
	
}
