package GigDatabase.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface GigRepository extends CrudRepository <Gig, Long>
{ List <Gig> findByDate (String Date); 
}