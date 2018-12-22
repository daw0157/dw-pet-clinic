package dw.pc.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dw.pc.model.Owner;
import dw.pc.model.Pet;
import dw.pc.model.PetType;
import dw.pc.model.Specialty;
import dw.pc.model.Vet;
import dw.pc.model.Visit;
import dw.pc.services.OwnerService;
import dw.pc.services.PetTypeService;
import dw.pc.services.SpecialtyService;
import dw.pc.services.VetService;
import dw.pc.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner{
	
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;
	private final VisitService visitService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialtyService specialtyService, VisitService visitService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		if(petTypeService.findAll().size()==0) {
			loadData();			
		}
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName(PetType.DOG);
		petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName(PetType.CAT);
		petTypeService.save(cat);
		
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

        Visit catVisit = new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("checkup");
        visitService.save(catVisit);
        
        Specialty radio = new Specialty();
        radio.setDescription("Radiology");
        specialtyService.save(radio);
        
        Specialty dentist = new Specialty();
        dentist.setDescription("Dentistry");
        specialtyService.save(dentist);
        
        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        specialtyService.save(surgery);
        

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(radio);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(dentist);
        vet2.getSpecialties().add(surgery);
        vetService.save(vet2);

        System.out.println("Loaded Pet Types...." + petTypeService.findAll().size());
        System.out.println("Loaded Owners...." + ownerService.findAll().size());
        System.out.println("Loaded Specialties...." + specialtyService.findAll().size());
	    System.out.println("Loaded Vets...." + vetService.findAll().size());
	    System.out.println("Loaded Visits...." + visitService.findAll().size());
	}

}
