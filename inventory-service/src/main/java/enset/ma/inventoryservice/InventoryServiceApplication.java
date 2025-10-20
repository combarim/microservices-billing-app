package enset.ma.inventoryservice;

import enset.ma.inventoryservice.entities.Product;
import enset.ma.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ProductRepository repository) {
		return args -> {
			repository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("Computer")
					.price(3200)
					.quantity(11)
					.build());
			repository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("Printer")
					.price(1900)
					.quantity(25)
					.build());
			repository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("Smartphone")
					.price(1400)
					.quantity(70)
					.build());

			repository.findAll().forEach(System.out::println);
		};

	}
}
