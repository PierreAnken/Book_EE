package library.libraryservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.faces.bean.SessionScoped;

import library.businessobject.Book;
import library.businessobject.Reader;

@Stateful
@SessionScoped
public class BagBean implements BagService {

	private List<Book> booksInBag;
	private Reader currentReader;
	
	
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
		for (Book b : booksInBag) {
			if (b.getId() == bId) {
				removeBook(b);
				break;
			}
		}
	}

	@Override
	public Map<String, Object> getCurrentReader() {
		return Reader.convertToMap(currentReader);
	}

	@Override
	public void setCurrentReader(Map<String, Object> reader) {
		currentReader = Reader.convertFromMap(reader);
	}

	@PostConstruct
	public void initialize() {
		booksInBag = new ArrayList<Book>();
		System.out.println("PA_DEBUG: Init BagBean");
	}

	@Override
	public boolean isBookInBag(String bookId) {
		boolean found = false;
		if (booksInBag.size() == 0) {
			return false;
		}
		for (Book b : booksInBag) {
			if (b.getId() == Integer.parseInt(bookId)) {
				found = true;
				break;
			}
		}
		return found;
	}
}