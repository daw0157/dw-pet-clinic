package dw.pc.model;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class PetType extends BaseEntity {

	private String name;
	
}
