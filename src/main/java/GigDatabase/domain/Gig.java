package GigDatabase.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gig {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	private String date;
	private String venue;
	private String time;
	
	public Gig(){
		
	}
	
	public Gig(String date, String venue, String time){
		super();
		this.date = date;
		this.venue = venue;
		this.time = time;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Gig [date=" + date + ", venue=" + venue + ", time=" + time
				+ "]";
	}
	
	

}
