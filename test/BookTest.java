import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

	@Test
	public void ConstructorBookTest(){
		Book book = new Book("1984", "Science Fiction", "Cappelenn", "George Orwell", 3);
		assertEquals("1984", book.getTitle());
		assertEquals("George Orwell", book.getAuthor());
		assertEquals("Science Fiction", book.getGenre());
		assertEquals("Cappelenn", book.getPublisher());
		assertEquals(3, book.getEdition());
	}

}



