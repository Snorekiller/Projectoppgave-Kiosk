import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import registry.BookRegister;
import litterature.Book;

import java.util.Iterator;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookRegisterTest {
	private static BookRegister bookRegister;
	private static Book book;
	private static Book book1;
	private static Book book2;

	@Before
	public void setUp() throws Exception {
		bookRegister = new BookRegister();
		book = new Book("1984", "George Orwell", "Science Fiction");
		book1 = new Book("Harry Potter and the deathly hallows", "JK Rowling", "Fantasy");
		book2 = new Book("The hitchhikers guide to the galaxy", "Douglas Adams", "Science Fiction");

		bookRegister.addBook(book);
		bookRegister.addBook(book1);
		bookRegister.addBook(book2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addBook() {

		assertEquals(book, bookRegister.search("1984"));

	}

	@Test
	public void getIterator() {
		Iterator<Book> bookItList = this.bookRegister.getIterator();
		int i = 1;
		while (bookItList.hasNext()){
			Book book = bookItList.next();
			if(i == 1){
				assertEquals("1984", book.getTitle());
			}
			if(i == 2){
				assertEquals("Harry Potter and the deathly hallows", book.getTitle());
			}
			if(i == 3){
				assertEquals("The hitchhikers guide to the galaxy", book.getTitle());
			}
			i++;
		}

	}

	@Test
	public void search() {
		assertEquals(book, bookRegister.search("1984"));
		assertNotEquals(book, bookRegister.search("Harry Potter and the deathly hallows"));
	}

	@Test
	public void deleteEntries() {
		bookRegister.deleteEntries("1984");
		assertNotEquals(book, bookRegister.search("1984"));
	}
}