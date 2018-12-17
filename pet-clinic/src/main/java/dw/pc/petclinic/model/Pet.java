package dw.pc.petclinic.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Pet {

	private String name;
	
}
