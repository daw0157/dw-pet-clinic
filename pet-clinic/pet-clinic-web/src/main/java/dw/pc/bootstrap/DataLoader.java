package dw.pc.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dw.pc.model.Owner;
import dw.pc.model.Pet;
import dw.pc.model.PetType;
import dw.pc.model.Vet;
import dw.pc.services.OwnerService;
import dw.pc.services.PetTypeService;
import dw.pc.services.VetService;

@Component
public class DataLoader implements CommandLineRunner{
	
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}


	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName(PetType.DOG);
		petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName(PetType.CAT);
		petTypeService.save(cat);
		
		System.out.println("Loaded Pet Types...." + petTypeService.findAll().size());
		
		Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Hiltons Lane");
        owner1.setCity("Miami");
        owner1.setTelephone("555-143-5555");
        
        Pet mikesPet = new Pet();
        mikesPet.setPetType(dog);
        mikesPet.setOwner(owner1);
        mikesPet.setName("Doggie");
        mikesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("321 Oak Hill Road");
        owner2.setCity("Barrington");
        owner2.setTelephone("555-143-1423");
        
        Pet fionasCat = new Pet();
        fionasCat.setPetType(cat);
        fionasCat.setOwner(owner2);
        fionasCat.setName("Kat");
        fionasCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(fionasCat);
        ownerService.save(owner2);
        
        Owner owner3 = new Owner();
        owner3.setFirstName("Tom");
        owner3.setLastName("Brady");
        owner3.setAddress("561 Main Street");
        owner3.setCity("Boston");
        owner3.setTelephone("555-231-4178");
        ownerService.save(owner3);

        System.out.println("Loaded Owners...." + ownerService.findAll().size());

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vetService.save(vet2);

	    System.out.println("Loaded Vets...." + vetService.findAll().size());
		
	}

}
