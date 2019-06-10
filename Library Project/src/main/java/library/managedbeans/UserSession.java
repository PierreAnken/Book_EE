package library.managedbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;

import library.businessobject.Book;
import library.businessobject.Librarian;
import library.businessobject.Reader;
import library.libraryservice.LibraryService;

@SessionScoped
@Stateful
public class UserSession{

	private List<Book> booksInBag;
	private Reader currentReader;
	private Librarian currentLibrarian;
	private LibraryService libraryService;
	
	@PostConstruct
	public void initialize() throws Exception {
		InitialContext ctx = new InitialContext();
		libraryService = (LibraryService)ctx.lookup("java:global/Library-0.0.1/LibraryBean!library.libraryservice.LibraryService");
		
		currentLibrarian = Librarian.convertFromMapList(libraryService.getLibrarians()).get(0);
		System.out.println("PA_DEBUG: Init  booksInBag "+getBooksInBag());
	}

	public Librarian getCurrentLibrarian() {
		return currentLibrarian;
	}

	public void setCurrentLibrarian(Librarian currentLibrarian) {
		this.currentLibrarian = currentLibrarian;
	}

	public void removeBook(Book b) {
		System.out.println("OG_DEBUG: Bag Been book remover " + b.getId());
		getBooksInBag().remove(b);
	}

	public int getBagSize() {
		return getBooksInBag().size();
	}
	
	public List<Book> getBooksInBag() {
		if(booksInBag == null)
			booksInBag = new ArrayList<Book>();
		return booksInBag;
	}

	public void addBookToBag(Book b) {
		System.out.println("OG_DEBUG: ReaderBag managedbean adding book to bag with ID " + b.getId() + " / " + getBooksInBag());
		getBooksInBag().add(b);
	}

	public void removeBookFromBag(int bId) {
		for (Book b : getBooksInBag()) {
			if (b.getId() == bId) {
				removeBook(b);
				break;
			}
		}
	}

	public Map<String, Object> getCurrentReader() {
		return Reader.convertToMap(currentReader);
	}

	public void setCurrentReader(Map<String, Object> reader) {
		currentReader = Reader.convertFromMap(reader);
	}

	public boolean isBookInBag(long bookId) {
		for(Book book : getBooksInBag()) {		
			if (book.getId() == bookId) {
				return true;
			}
		}
		return false;
	}
}