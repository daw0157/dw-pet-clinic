package dw.pc.services;

import java.util.Set;

import dw.pc.model.Pet;

public interface PetService {

	Pet findById(Long id);
	
	Pet save(Pet pet);
	
	Set<Pet> findAll();
	
}
