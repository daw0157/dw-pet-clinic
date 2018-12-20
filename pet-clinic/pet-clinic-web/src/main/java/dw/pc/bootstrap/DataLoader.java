package dw.pc.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dw.pc.model.Owner;
import dw.pc.model.Vet;
import dw.pc.services.OwnerService;
import dw.pc.services.VetService;

@Component
public class DataLoader implements CommandLineRunner{
	
	private final OwnerService ownerService;
	private final VetService vetService;
	
	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Owner owner1 = new Owner();
		owner1.setId(1L);
		owner1.setFirstName("Joe");
		owner1.setLastName("Smith");
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setId(2L);
		owner2.setFirstName("Mark");
		owner2.setLastName("Andrews");
		
		ownerService.save(owner2);
		
		System.out.println("Loaded Owners");
		
		Vet vet1 = new Vet();
		vet1.setId(1L);
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setId(2L);
		vet2.setFirstName("Sadie");
		vet2.setLastName("Dog");
		vetService.save(vet2);
		
		System.out.println("Loaded vets");
		
	}

}
