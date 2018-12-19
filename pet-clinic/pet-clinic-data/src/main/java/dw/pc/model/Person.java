package dw.pc.model;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Person extends BaseEntity {

	private String firstName;
	private String lastName;
	
}
