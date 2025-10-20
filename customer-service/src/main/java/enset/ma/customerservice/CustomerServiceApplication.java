package enset.ma.customerservice;

import enset.ma.customerservice.entities.Customer;
import enset.ma.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder()
                    .name("Mohammed").email("mohammed@gmail.com")
                    .build()
            );
            customerRepository.save(Customer.builder()
                    .name("Aicha").email("aicha@gmail.com")
                    .build()
            );
            customerRepository.save(Customer.builder()
                    .name("Youssef").email("youssef@gmail.com")
                    .build()
            );
            customerRepository.findAll().forEach((c) -> {
                System.out.println("--------------------");
                System.out.println(c.getId());
                System.out.println(c.getName());
                System.out.println(c.getEmail());
                System.out.println("--------------------");
            });
        };
    }

}
