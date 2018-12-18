package dw.pc.petclinic.model;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class PetType {

	private String name;
	
}
