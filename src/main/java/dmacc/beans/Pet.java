package dmacc.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;



/**
 * Audrey N. Johnston - ajohnston10
 * CIS175
 * Mar 5, 2024
 */

@Entity
public class Pet {
	@Id
	@GeneratedValue
		private int id;
		private String type;
		private String name;
		private String owner;

		
		//Getter and Setter methods
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		public String getOwner() {
			return owner;
		}
		public void setOwner(String owner) {
			this.owner = owner;
		}
		

		//Constructors
		public Pet() {
			super();
		}
		
		public Pet (String type, String name, String owner) {
			super();
			this.type = type;
			this.name = name;
			this.owner = owner;
		}
		
		
		public	String returnPetDetails() {	
			return "Owner: " + this.owner + " - Pet Name: " + this.name + " - Type: " + this.type;
		}
}






	
	
	

