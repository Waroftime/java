package de.javaee.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Represent a language.
 *
 * @author Nils Schulist
 */

@Entity
public class Language {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "language_id")
  private int id;

  @NotNull
  @Column(columnDefinition = "bpchar")
  private String name;

  @NotNull
  //@Temporal(TemporalType.TIMESTAMP)
  @Column(name = "last_update", columnDefinition = "timestamp without time zone")
  private LocalDate lastUpdate;
  
  public Language() {
 
  }
  
  public Language(String name) {
		this.name = name;
		update();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		update();
	}

	public int getId() {
		return id;
	}

	public LocalDate getLastUpdate() {
		return lastUpdate;
	}

	private void update() {
    lastUpdate = LocalDate.now();
  }
}

