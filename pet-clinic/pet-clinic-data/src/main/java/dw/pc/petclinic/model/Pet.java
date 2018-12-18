package dw.pc.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Pet {

	private PetType petType;
	//private Owner owner;
	private LocalDate birthDate;
	private String name;
	
}
