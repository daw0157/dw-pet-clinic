package dw.pc.model;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Pet extends BaseEntity {

	//private PetType petType;
	//private Owner owner;
	private LocalDate birthDate;
	private String name;
	
}
