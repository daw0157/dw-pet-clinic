package dw.pc.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Person {

<<<<<<< HEAD:pet-clinic/src/main/java/dw/pc/petclinic/model/Person.java
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
=======
>>>>>>> parent of 233653c... multi-module project:pet-clinic/src/main/java/dw/pc/petclinic/model/Person.java
	private String firstName;
	private String lastName;
	
}
