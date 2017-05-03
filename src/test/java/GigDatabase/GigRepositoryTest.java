package GigDatabase;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import GigDatabase.domain.Gig;
import GigDatabase.domain.GigRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GigRepositoryTest {

	@Autowired
	private GigRepository repository;
	
	@Test
	public void findByDateShouldReturnGig(){
		 List<Gig> gigs = repository.findByDate("1.5.2017");
		 
		 assertThat(gigs).isNotNull();
		 
	}
	@Test
    public void createNewGig() {
		Gig gig = new Gig("1.5.2017", "LeBonk", "2200 - 0330");
		repository.save(gig);
		assertThat(gig.getId()).isNotNull();
	}
	
}
