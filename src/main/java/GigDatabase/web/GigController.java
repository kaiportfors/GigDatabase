package GigDatabase.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import GigDatabase.domain.Gig;
import GigDatabase.domain.GigRepository;

@Controller
public class GigController {
	@Autowired
	private GigRepository repository; 
	
	// Show all students
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	@RequestMapping(value="/giglist", method=RequestMethod.GET)
	public String displayGig(Model model){
		model.addAttribute("gigs", repository.findAll());
		return "giglist";
	}
    
	// RESTful service to get all students
    @RequestMapping(value="/gigs", method = RequestMethod.GET)
    public @ResponseBody List<Gig> gigListRest() {	
        return (List<Gig>) repository.findAll();
    }    

	// RESTful service to get student by id
    @RequestMapping(value="/gig/{id}", method = RequestMethod.GET)
    public @ResponseBody Gig findGigRest(@PathVariable("id") Long gigId) {	
    	return repository.findOne(gigId);
} 
    
	@RequestMapping (value = "/add")
	public String addGig(Model model){
		model.addAttribute("gig", new Gig());
		return "addgig";
	}
	
	@RequestMapping (value = "/save", method=RequestMethod.POST)
	public String saveGig(Gig gig){
		repository.save(gig);
		return "redirect:giglist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteGig(@PathVariable("id") Long gigId, Model model ){
		repository.delete(gigId);
		return "redirect:../giglist";
}
}


