package dw.pc.model;

public class PetType extends BaseEntity {
	
	public static final String DOG = "Dog";
	public static final String CAT = "Cat";

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
