package dw.pc.repositories;

import org.springframework.data.repository.CrudRepository;

import dw.pc.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
