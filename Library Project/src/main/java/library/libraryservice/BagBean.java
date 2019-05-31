package library.libraryservice;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;

import library.businessobject.Book;

@Stateful
public class BagBean implements BagService {

	private List<Book> booksInBag;	
	private 
	
	@Override
	public void removeBook(Book b) {
		booksInBag.add(b);
	}

	@Override
	public void addBook(Book b) {
		booksInBag.remove(b);
	}

	@Override
	public void removeBook(int bId) {
		for(Book b : booksInBag) {
			if(b.getId() == bId) {
				removeBook(b);
				break;
			}
		}
	}
	
	@PostConstruct
	public void initialize() {
		booksInBag = new ArrayList<Book>();
	}
	
	@PreDestroy
	public void clear() {
		booksInBag = null;
	}

}