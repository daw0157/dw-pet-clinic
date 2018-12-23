package dw.pc.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dw.pc.model.Owner;

class OwnerServiceMapTest {
	
	OwnerServiceMap ownerServiceMap;
	
	final Long ownerId = 1L;
	final String lastName = "Jones";

	@BeforeEach
	void setUp() {
		ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
		
		ownerServiceMap.save(Owner.builder().id(ownerId).lastName(lastName).build());
	}
	
	@Test
	void testFindAll() {
		Set<Owner> ownerSet = ownerServiceMap.findAll();
		
		assertEquals(1, ownerSet.size());
	}

	@Test
	void testFindByIdLong() {
		Owner owner = ownerServiceMap.findById(ownerId);
		assertEquals(ownerId, owner.getId());
	}

	@Test
	void testSaveExistingIdOwner() {
		Long id = 2L;
		
		Owner owner2 = Owner.builder().id(id).build();
		
		Owner savedOwner = ownerServiceMap.save(owner2);
		
		assertEquals(id, savedOwner.getId());
	}
	
	@Test
	void testSaveNoIdOwner() {
		Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}

	@Test
	void testDeleteOwner() {
		ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
		
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	void testDeleteByIdLong() {
		ownerServiceMap.deleteById(ownerId);
		assertEquals(0, ownerServiceMap.findAll().size());
	}

	@Test
	void testFindByLastName() {
		Owner owner = ownerServiceMap.findByLastName(lastName);
		assertNotNull(owner);
		assertEquals(ownerId, owner.getId());
	}
	
	@Test
	void testFindByLastNameNotExisting() {
		Owner owner = ownerServiceMap.findByLastName("foo");
		assertNull(owner);
	}

}
