package dmacc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import dmacc.beans.Pet;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.PetRepository;

@SpringBootApplication
public class SpringPetsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringPetsApplication.class, args);
	}

	@Autowired
	PetRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		//Using an existing bean
		Pet p = appContext.getBean("pet", Pet.class);
		p.setType("Dog");
		repo.save(p);
		
		//Create a bean to use - not managed by Spring
		Pet d = new Pet("Dog", "Daisy", "Sophie");
		repo.save(d);
		
		List<Pet> allPets = repo.findAll();
		System.out.println("\n************************************");
		for(Pet pet: allPets) {
			System.out.println(pet.returnPetDetails());
		}
		System.out.println("\n************************************");
		
		//closes the ApplicationContext resource leak - not imperative to add but nice to clean it up
		((AbstractApplicationContext) appContext).close();
	
	}
}
