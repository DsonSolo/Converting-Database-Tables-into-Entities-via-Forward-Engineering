package domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the animal database table.
 * 
 */
@Entity
@NamedQuery(name="Animal.findAll", query="SELECT a FROM Animal a")
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="animal_id")
	private int animalId;

	@Column(name="animal_name")
	private String animalName;

	//bi-directional many-to-many association to Event
	@ManyToMany
	@JoinTable(
		name="animal_event"
		, joinColumns={
			@JoinColumn(name="anmal_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="evnt_id")
			}
		)
	private Set<Event> events;

	public Animal() {
	}

	public int getAnimalId() {
		return this.animalId;
	}

	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}

	public String getAnimalName() {
		return this.animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public Set<Event> getEvents() {
		return this.events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

}