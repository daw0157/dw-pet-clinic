package dw.pc.model;

import java.io.Serializable;

import lombok.Data;

public class BaseEntity implements Serializable {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
