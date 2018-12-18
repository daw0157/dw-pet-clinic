package dw.pc.petclinic.model;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Person {

	private String firstName;
	private String lastName;
	
}
