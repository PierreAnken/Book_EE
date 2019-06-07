package library.businessobject;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Reader extends User implements Serializable{

	private static final long serialVersionUID = -7085265629390248126L;
	private int cardId;
	private double accountBalance;
	
	@OneToMany(mappedBy="reader", cascade={CascadeType.REMOVE})
	private Set<Reservation> reservations;

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public int getCardId() {
		return cardId;
	}
	
	// Constructors
	public Reader() {
	}

	public Reader(String email, String firstname, String lastname, int cardId, Address address) {
		super(email,  firstname, lastname, address);
		this.cardId = cardId;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
}
