package dw.pc.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Owner extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
}
