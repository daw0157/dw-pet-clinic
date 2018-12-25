package dw.pc.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.stereotype.Service;

import dw.pc.model.Owner;
import dw.pc.repositories.OwnerRepository;
import dw.pc.repositories.PetRepository;
import dw.pc.repositories.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
class OwnerServiceSDJpaTest {

	private static final long ID_ONE = 1L;
	private static final long ID_TWO = 2L;

	private static final String LAST_NAME = "Smith";

	@Mock
	OwnerRepository ownerRepository;
	
	@Mock
	PetRepository petRepository;
	
	@Mock
	PetTypeRepository petTypeRepository;
	
	@InjectMocks
	OwnerServiceSDJpa ownerService;
	
	Owner returnOwner;
	
	@BeforeEach
	void setUp() {
		returnOwner = Owner.builder().id(ID_ONE).lastName(LAST_NAME).build();
	}
	
	@Test
	void testFindByLastName() {
		when(ownerService.findByLastName(any())).thenReturn(returnOwner);
		
		Owner smith = ownerService.findByLastName(LAST_NAME);
		
		assertEquals(LAST_NAME, smith.getLastName());
		
		verify(ownerRepository).findByLastName(any());
	}
	
	@Test
	void testFindAll() {
		Set<Owner> returnOwnersSet = new HashSet<>();
		returnOwnersSet.add(Owner.builder().id(ID_ONE).build());
		returnOwnersSet.add(Owner.builder().id(ID_TWO).build());
		
		when(ownerRepository.findAll()).thenReturn(returnOwnersSet);
		
		Set<Owner> owners = ownerService.findAll();
		
		assertNotNull(owners);
		assertEquals(2, owners.size());
	}

	@Test
	void testFindById() {
		when(ownerRepository.findById(any(Long.class))).thenReturn(Optional.of(returnOwner));
		
		Owner owner = ownerService.findById(ID_ONE);
		
		assertNotNull(owner);
	}
	
	@Test
	void testFindByIdIsNull() {
		when(ownerRepository.findById(any(Long.class))).thenReturn(Optional.empty());
		
		Owner owner = ownerService.findById(ID_ONE);
		
		assertNull(owner);
	}

	@Test
	void testSave() {
		Owner ownerToSave = Owner.builder().id(ID_ONE).build();
		when(ownerRepository.save(any())).thenReturn(returnOwner);
		Owner savedOwner = ownerService.save(ownerToSave);
		assertNotNull(savedOwner);
		verify(ownerRepository).save(any());
	}

	@Test
	void testDelete() {
		ownerService.delete(returnOwner);
		
		verify(ownerRepository).delete(any());
	}

	@Test
	void testDeleteById() {
		ownerService.deleteById(ID_ONE);
		
		verify(ownerRepository).deleteById(any(Long.class));
	}

}
