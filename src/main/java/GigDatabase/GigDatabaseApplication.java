package GigDatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import GigDatabase.domain.User;
import GigDatabase.domain.Gig;
import GigDatabase.domain.GigRepository;
import GigDatabase.domain.UserRepository;

@SpringBootApplication

public class GigDatabaseApplication {
	private static final Logger log = LoggerFactory.getLogger(GigDatabaseApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(GigDatabaseApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner gigsDemo(GigRepository repository, UserRepository urepository){
		return (args) -> {
			log.info("save a couple of gigs");
			repository.save(new Gig("21.4.2017", "LeBonk", "2200 - 0330"));
			repository.save(new Gig("22.4.2017", "LeBonk", "2200 - 0330"));
			repository.save(new Gig("28.4.2017", "Skohan", "2200 - 0330"));
			repository.save(new Gig("29.4.2017", "LeBonk", "2200 - 0330"));
			repository.save(new Gig("29.4.2017", "Uggla", "2200 - 0330"));
			log.info("fetch all gigs");
			for (Gig gig : repository.findAll()){
				log.info(gig.toString());
			}
			
			User user1 = new User("user", "$2a$04$iNpwYcE5/TVRvCuCG4hsau91MQMAjVeSPzB.KR9K5h6NtSI6XCPcq", "USER");
			User user2 = new User("admin", "$2a$04$iNpwYcE5/TVRvCuCG4hsau91MQMAjVeSPzB.KR9K5h6NtSI6XCPcq", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
	};
	
	}
}
