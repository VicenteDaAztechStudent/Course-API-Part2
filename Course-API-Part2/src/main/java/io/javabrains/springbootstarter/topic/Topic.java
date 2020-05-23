//SpringBoot QS 12


package io.javabrains.springbootstarter.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

// Tells JPA that this is an Entity Class, needed to create a relational database
// Create a table with 3 columns id, name, description
@Entity
// Class to create 'Topics' objects 
public class Topic {
	
	// Tells JPA that column 'id' is where the 'Primary Key' will be stored for each Topic
	@Id
	private String id;
	private String name;
	private String description;
	
	 
	// Have a non-argument constructor to make it
	// Easier to initialize
	public Topic() {

	}	
	
	// Create constructor that takes parameters
	// And initialize object
	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	
	// Have GETers and SETers methods
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
