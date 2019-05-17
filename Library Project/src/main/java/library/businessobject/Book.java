package library.businessobject;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	
	private String title, description, author;
	private int currentOwner;
	private boolean isAvailable;
	private Language Language;

	@ManyToOne
	private Location location;
	
	@ManyToOne
	private Library library;
	
	@ManyToMany
	private Set<Reservation> Reservations;
	
	public Set<Reservation> getReservations() {
		return Reservations;
	}
	public void setReservations(Set<Reservation> Reservations) {
		this.Reservations = Reservations;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType. IDENTITY)
	private Long id;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Language getLanguage() {
		return Language;
	}
	
	public void setLanguage(Language language) {
		Language = language;
	}
	
	public int getCurrentOwner() {
		return currentOwner;
	}
	
	public void setCurrentOwner(int currentOwner) {
		this.currentOwner = currentOwner;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	// constructors
	public Book() {
	}

	public Book(String title, String description, String author, int currentOwner, boolean isAvailable, Language language, Location location, Library library) {
		this.title = title;
		this.description = description;
		this.author = author;
		this.currentOwner = currentOwner;
		this.isAvailable = isAvailable;
		this.Language = language;
		this.location = location;
		this.library = library;
	}

	
}
